package com.carton.service.impl;

import com.carton.mapper.AccountMapper;
import com.carton.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:54
 ************************************************************/

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


}
