package com.carton.controller;

import com.carton.model.CartonCategory;
import com.carton.service.CartonCategoryService;
import com.carton.service.LovService;
import com.carton.util.BaseBeanUtil;
import com.carton.util.Context;
import com.carton.vo.CartonCategoryVO;
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
 * @Date 2018-06-22 21:12
 ************************************************************/

@Controller
@RequestMapping("/cartonCategory")
public class CartonCategoryController extends BaseController<CartonCategoryVO> {

    @Autowired
    private CartonCategoryService cartonCategoryService;

    @Autowired
    private LovService lovService;

    @RequestMapping("/cartonCategoryList")
    public String getCartonCategoryList(Model model,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "5") Integer pageSize,
                                        @RequestParam(required = false) String bigCategoryParam,
                                        @RequestParam(required = false) String smallCategoryParam) {
        Map<String, Object> params = new HashMap<>();
        PageInfo<CartonCategoryVO> pageInfo = cartonCategoryService.getCartonCategoryList(pageNum, pageSize, params);
        model.addAttribute("cartonCategoryList", pageInfo.getList());
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

        return "carton/carton_category_list";
    }

    @RequestMapping(value = "/toAddPage", method = RequestMethod.GET)
    public String toAddPage(Model model) {
        //lov下拉框
        List<LovVO> bigCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, null, null);
        model.addAttribute("bigCategoryLovList", bigCategoryLovList);

        return "carton/carton_category_add";
    }

    @RequestMapping(value = "/toEditPage", method = RequestMethod.GET)
    public String toEditPage(Model model, @RequestParam("id") Integer id) {

        CartonCategory cartonCategory = cartonCategoryService.getCartonCategoryDetail(id);
        CartonCategoryVO cartonCategoryVO = BaseBeanUtil.convertCartonCategory2VO(cartonCategory);
        model.addAttribute("cartonCategory", cartonCategoryVO);

        //lov下拉框
        List<LovVO> bigCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, null, null);
        model.addAttribute("bigCategoryLovList", bigCategoryLovList);
        List<LovVO> smallCategoryLovList = lovService.getLovByCondition(Context.CARTON_CATEGORY, cartonCategory.getCartonBigType(), null);
        model.addAttribute("smallCategoryLovList", smallCategoryLovList);

        return "carton/carton_category_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/addCartonCategory", method = RequestMethod.POST)
    public Result addCartonCategory(CartonCategoryVO cartonCategoryVO) {
        CartonCategory cartonCategory = BaseBeanUtil.convertCartonCategoryVO2Entity(cartonCategoryVO);
        return cartonCategoryService.addCartonCategory(cartonCategory);
    }

    @ResponseBody
    @RequestMapping(value = "/editCartonCategory", method = RequestMethod.POST)
    public Result editCartonCategory(CartonCategoryVO cartonCategoryVO) {
        CartonCategory cartonCategory = BaseBeanUtil.convertCartonCategoryVO2Entity(cartonCategoryVO);
        return cartonCategoryService.editCartonCategory(cartonCategory);
    }

}
