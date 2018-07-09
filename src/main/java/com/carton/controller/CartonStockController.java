package com.carton.controller;

import com.carton.model.CartonStock;
import com.carton.service.CartonStockService;
import com.carton.service.LovService;
import com.carton.util.BaseBeanUtil;
import com.carton.util.Context;
import com.carton.vo.CartonStockVO;
import com.carton.vo.LovVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-28 10:35
 ************************************************************/

@Controller
@RequestMapping("/cartonStock")
public class CartonStockController extends BaseController<CartonStockVO> {

    @Autowired
    private CartonStockService cartonStockService;

    @Autowired
    private LovService lovService;

    @RequestMapping("/cartonStockList")
    public String getCartonStockList(Model model,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                     @RequestParam(required = false) String bigCategoryParam,
                                     @RequestParam(required = false) String smallCategoryParam,
                                     @RequestParam(required = false) String name) {
        Map<String, Object> params = new HashMap<>();
        PageInfo<CartonStockVO> pageInfo = cartonStockService.getCartonStockList(pageNum, pageSize, params);
        model.addAttribute("cartonStockList", pageInfo.getList());
        setPageInfo2Model(model, pageInfo);

        //lov下拉框
        List<LovVO> bigCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, null, null);
        model.addAttribute("bigCategoryLovList", bigCategoryLovList);
        if (StringUtils.isNotBlank(bigCategoryParam)) {
            List<LovVO> smallCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, bigCategoryParam, null);
            model.addAttribute("smallCategoryLovList", smallCategoryLovList);
        }

        //回显表单自定义搜索项
        model.addAttribute("bigCategoryParam", bigCategoryParam == null ? "" : bigCategoryParam);
        model.addAttribute("smallCategoryParam", smallCategoryParam == null ? "" : smallCategoryParam);
        model.addAttribute("name", name == null ? "" : name);

        return "carton/carton_stock_list";
    }

    @RequestMapping(value = "/toAddPage", method = RequestMethod.GET)
    public String toAddPage(Model model) {
        //lov下拉框
        List<LovVO> bigCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, null, null);
        model.addAttribute("bigCategoryLovList", bigCategoryLovList);

        return "carton/carton_stock_add";
    }

    @RequestMapping(value = "/toEditPage", method = RequestMethod.GET)
    public String toEditPage(Model model, @RequestParam("id") Integer id) {

        CartonStock cartonStock = cartonStockService.getCartonStockDetail(id);
        CartonStockVO cartonStockVO = BaseBeanUtil.convertCartonStock2VO(cartonStock);
        model.addAttribute("cartonStock", cartonStockVO);

        //lov下拉框
        List<LovVO> bigCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, null, null);
        model.addAttribute("bigCategoryLovList", bigCategoryLovList);
        List<LovVO> smallCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, cartonStock.getCartonCategory().getCartonSmallType(), null);
        model.addAttribute("smallCategoryLovList", smallCategoryLovList);

        return "carton/carton_stock_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/addCartonStock", method = RequestMethod.POST)
    public Result addCartonStock(CartonStockVO cartonStockVO) {
        CartonStock cartonStock = BaseBeanUtil.convertCartonStockVO2Entity(cartonStockVO);
        return cartonStockService.addCartonStock(cartonStock);
    }

    @ResponseBody
    @RequestMapping(value = "/editCartonStock", method = RequestMethod.POST)
    public Result editCartonStock(CartonStockVO cartonStockVO) {
        CartonStock cartonStock = BaseBeanUtil.convertCartonStockVO2Entity(cartonStockVO);
        return cartonStockService.editCartonStock(cartonStock);
    }

}
