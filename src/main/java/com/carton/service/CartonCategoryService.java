package com.carton.service;

import com.carton.model.CartonCategory;
import com.carton.vo.CartonCategoryVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:54
 ************************************************************/

public interface CartonCategoryService {
    PageInfo<CartonCategory> getCartonCategoryList(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result addCartonCategory(CartonCategory cartonCategory);

    CartonCategory getCartonCategoryDetail(Integer id);

    Result editCartonCategory(CartonCategory cartonCategory);

    List<Map<String,Object>> getSimpleCartonCategoryList();
}
