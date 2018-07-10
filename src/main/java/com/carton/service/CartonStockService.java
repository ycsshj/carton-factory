package com.carton.service;

import com.carton.model.CartonStock;
import com.carton.vo.CartonStockVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:55
 ************************************************************/

public interface CartonStockService {
    PageInfo<CartonStock> getCartonStockList(Integer pageNum, Integer pageSize, Map<String, Object> params);

    CartonStock getCartonStockDetail(Integer id);

    Result addCartonStock(CartonStock cartonStock);

    Result editCartonStock(CartonStock cartonStock);
}
