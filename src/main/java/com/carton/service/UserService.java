package com.carton.service;

import com.carton.model.User;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:56
 ************************************************************/

public interface UserService {
    User validateUser(String userName, String passWord);
}
