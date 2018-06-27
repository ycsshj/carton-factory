package com.carton.controller;

import com.carton.service.LovService;
import com.carton.vo.CartonCategoryVO;
import com.carton.vo.LovVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-22 21:12
 ************************************************************/

@Controller
@RequestMapping("/lov")
public class LovController extends BaseController<CartonCategoryVO> {

    @Autowired
    private LovService lovService;

    @ResponseBody
    @RequestMapping(value = "/getLovByCondition", method = RequestMethod.GET)
    public List<LovVO> getLovByCondition(@RequestParam("category") String category,
                                         @RequestParam("parentCode") String parentCode,
                                         @RequestParam("lovCode") String lovCode) {
        return lovService.getLovByCondition(category, parentCode, lovCode);
    }

}
