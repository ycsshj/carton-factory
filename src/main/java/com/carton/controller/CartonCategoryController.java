package com.carton.controller;

import com.carton.service.CartonCategoryService;
import com.carton.vo.CartonCategoryVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
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

    @RequestMapping("/cartonCategoryList")
    public String getCartonCategoryList(Model model,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "5") Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        PageInfo<CartonCategoryVO> pageInfo = cartonCategoryService.getCartonCategoryList(pageNum, pageSize, params);
        model.addAttribute("cartonCategoryList", pageInfo.getList());
        setPageInfo2Model(model, pageInfo);

        //回显表单自定义搜索项
        //model.addAttribute("fileName", fileName);

        return "carton/carton_category_list";
    }

}
