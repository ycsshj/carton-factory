package com.carton.controller;

import com.carton.model.CartonOrder;
import com.carton.service.AccountService;
import com.carton.service.CartonOrderService;
import com.carton.service.CartonStockService;
import com.carton.util.BaseBeanUtil;
import com.carton.util.DateUtils;
import com.carton.util.ExporterUtil;
import com.carton.util.LogExceptionStackTrace;
import com.carton.vo.CartonInfoVO;
import com.carton.vo.CartonOrderVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-28 10:35
 ************************************************************/

@Controller
@RequestMapping("/cartonOrder")
public class CartonOrderController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CartonOrderController.class);

    @Autowired
    private CartonOrderService cartonOrderService;

    @Autowired
    private CartonStockService cartonStockService;

    @Autowired
    private ExporterUtil exporterUtil;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/cartonOrderList")
    public String getCartonOrderList(Model model,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                     @RequestParam(required = false) String nameParam) {
        Map<String, Object> params = new HashMap<>();
        params.put("nameParam", nameParam);

        PageInfo<CartonOrder> pageInfo = cartonOrderService.getCartonOrderList(pageNum, pageSize, params);
        model.addAttribute("cartonOrderList", BaseBeanUtil.convertCartonOrderList2VOs(pageInfo.getList()));
        setPageInfo2Model(model, pageInfo);

        //回显表单自定义搜索项
        model.addAttribute("nameParam", nameParam == null ? "" : nameParam);

        return "order/carton_order_list";
    }

    @RequestMapping(value = "/toAddPage", method = RequestMethod.GET)
    public String toAddPage(Model model) {
        List<Map<String, Object>> cartonStockList = cartonStockService.getSimpleCartonStockList();
        model.addAttribute("cartonStockList", cartonStockList);

        List<Map<String, Object>> accountList = accountService.getSimpleAccountList();
        model.addAttribute("accountList", accountList);

        return "order/carton_order_add";
    }

    @RequestMapping(value = "/toEditPage", method = RequestMethod.GET)
    public String toEditPage(Model model, @RequestParam("id") Integer id) {
        CartonOrder cartonOrder = cartonOrderService.getCartonOrderById(id);
        CartonOrderVO cartonOrderVO = BaseBeanUtil.convertCartonOrder2VO(cartonOrder);
        model.addAttribute("cartonOrder", cartonOrderVO);

        List<Map<String, Object>> cartonStockList = cartonStockService.getSimpleCartonStockList();
        model.addAttribute("cartonStockList", cartonStockList);

        List<Map<String, Object>> accountList = accountService.getSimpleAccountList();
        model.addAttribute("accountList", accountList);

        return "order/carton_order_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/addCartonOrder", method = RequestMethod.POST)
    public Result addCartonOrder(CartonOrderVO cartonOrderVO) {
        CartonOrder cartonOrder = BaseBeanUtil.convertCartonOrderVO2Entity(cartonOrderVO);
        return cartonOrderService.addCartonOrder(cartonOrder);
    }

    @ResponseBody
    @RequestMapping(value = "/editCartonOrder", method = RequestMethod.POST)
    public Result editCartonOrder(CartonOrderVO cartonOrderVO) {
        CartonOrder CartonOrder = BaseBeanUtil.convertCartonOrderVO2Entity(cartonOrderVO);
        return cartonOrderService.editCartonOrder(CartonOrder);
    }

    @ResponseBody
    @RequestMapping(value = "/downLoadOrderInfo", method = RequestMethod.GET)
    public void downLoadOrderInfo(@RequestParam Integer[] orderIds, HttpServletResponse response) {

        ServletOutputStream outputStream = null;
        HSSFWorkbook hssfWorkbook = null;
        try {

            List<CartonInfoVO> cartonOrderList = cartonOrderService.getOrderInfo4DownLoad(orderIds);
            String[] columns = {"客户名称", "联系方式", "纸箱大类", "纸箱小类", "长", "宽", "高", "纸箱规格", "压线规格",
                    "库存名称", "库存总数", "剩余库存数",
                    "订单名称", "订单数量", "发货日期"};
            String[] fields = {"accountName", "phone", "cartonBigTypeValue", "cartonSmallTypeValue", "cartonLength", "cartonWidth", "cartonHeight", "cartonStandard", "criticalStandard",
                    "stockName", "stock", "stockLeft",
                    "orderName", "amount", "publishDate"};
            hssfWorkbook = exporterUtil.exportExcel(columns, fields, cartonOrderList);
            String fileName = "客户订单_" + DateUtils.getCurrentDateTimeShort() + ".xlsx";

            //清空response
            response.reset();

            //设置response的Header
            response.addHeader("Content-Disposition", String.format("attachment;filename=%s", URLEncoder.encode(fileName, "UTF-8")));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");

        } catch (Exception ex) {
            hssfWorkbook = new HSSFWorkbook();
            HSSFSheet sheet = hssfWorkbook.createSheet();
            HSSFRow row = sheet.createRow((short) 0);
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue("系统错误, 请联系你老表!");
        }

        try {
            outputStream = response.getOutputStream();
            hssfWorkbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
        }
    }
}
