package com.carton.controller;

import com.carton.model.CartonStock;
import com.carton.service.CartonCategoryService;
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
public class CartonStockController extends BaseController {

    @Autowired
    private CartonStockService cartonStockService;

    @Autowired
    private CartonCategoryService cartonCategoryService;

    @RequestMapping("/cartonStockList")
    public String getCartonStockList(Model model,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                     @RequestParam(required = false) Integer cartonCategoryParam,
                                     @RequestParam(required = false) String nameParam) {
        Map<String, Object> params = new HashMap<>();
        params.put("cartonCategoryParam", cartonCategoryParam);
        params.put("nameParam", nameParam);

        PageInfo<CartonStock> pageInfo = cartonStockService.getCartonStockList(pageNum, pageSize, params);
        model.addAttribute("cartonStockList", BaseBeanUtil.convertCartonStockList2VOs(pageInfo.getList()));
        setPageInfo2Model(model, pageInfo);

        List<Map<String, Object>> categoryList = cartonCategoryService.getSimpleCartonCategoryList();
        model.addAttribute("cartonCategoryList", categoryList);

        //回显表单自定义搜索项
        model.addAttribute("cartonCategoryParam", cartonCategoryParam == null ? "" : cartonCategoryParam);
        model.addAttribute("nameParam", nameParam == null ? "" : nameParam);

        return "carton/carton_stock_list";
    }

    @RequestMapping(value = "/toAddPage", method = RequestMethod.GET)
    public String toAddPage(Model model) {

        List<Map<String, Object>> categoryList = cartonCategoryService.getSimpleCartonCategoryList();
        model.addAttribute("cartonCategoryList", categoryList);

        return "carton/carton_stock_add";
    }

    @RequestMapping(value = "/toEditPage", method = RequestMethod.GET)
    public String toEditPage(Model model, @RequestParam("id") Integer id) {

        CartonStock cartonStock = cartonStockService.getCartonStockDetail(id);
        CartonStockVO cartonStockVO = BaseBeanUtil.convertCartonStock2VO(cartonStock);
        model.addAttribute("cartonStock", cartonStockVO);

        List<Map<String, Object>> categoryList = cartonCategoryService.getSimpleCartonCategoryList();
        model.addAttribute("cartonCategoryList", categoryList);

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
