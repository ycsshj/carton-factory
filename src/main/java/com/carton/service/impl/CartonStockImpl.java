package com.carton.service.impl;

import com.carton.mapper.CartonStockMapper;
import com.carton.service.CartonStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:55
 ************************************************************/

@Service
public class CartonStockImpl implements CartonStock {

    @Autowired
    private CartonStockMapper cartonStockMapper;

}
