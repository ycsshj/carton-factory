package com.carton.service;

import com.carton.vo.CartonCategoryVO;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:54
 ************************************************************/

public interface CartonCategoryService {
    PageInfo<CartonCategoryVO> getCartonCategoryList(Integer pageNum, Integer pageSize, Map<String, Object> params);
}
