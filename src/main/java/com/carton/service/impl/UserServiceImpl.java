package com.carton.service.impl;

import com.carton.mapper.UserMapper;
import com.carton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:56
 ************************************************************/

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

}
