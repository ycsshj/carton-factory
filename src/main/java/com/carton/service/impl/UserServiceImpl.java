package com.carton.service.impl;

import com.carton.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:56
 ************************************************************/

@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

}
