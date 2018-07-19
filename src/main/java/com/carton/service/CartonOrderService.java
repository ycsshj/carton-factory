package com.carton.service;

import com.carton.model.CartonOrder;
import com.carton.vo.CartonInfoVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map; /************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:55
 ************************************************************/

public interface CartonOrderService {
    PageInfo<CartonOrder> getCartonOrderList(Integer pageNum, Integer pageSize, Map<String, Object> params);

    CartonOrder getCartonOrderById(Integer id);

    Result addCartonOrder(CartonOrder cartonOrder);

    Result editCartonOrder(CartonOrder cartonOrder);

    List<CartonInfoVO> getOrderInfo4DownLoad(Integer[] orderIds);
}
