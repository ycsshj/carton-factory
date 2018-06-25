package com.carton.service.impl;

import com.carton.mapper.CartonOrderMapper;
import com.carton.service.CartonOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:55
 ************************************************************/

@Service
public class CartonOrderServiceImpl implements CartonOrderService {

    @Autowired
    private CartonOrderMapper cartonOrderMapper;

}
