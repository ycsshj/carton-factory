package com.carton.service;

import com.carton.model.Account;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:54
 ************************************************************/

public interface AccountService {
    PageInfo<Account> getAccountList(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Account getAccountById(Integer id);

    Result addAccount(Account account);

    Result editAccount(Account account);

    List<Map<String,Object>> getSimpleAccountList();

}
