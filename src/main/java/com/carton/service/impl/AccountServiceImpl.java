package com.carton.service.impl;

import com.alibaba.fastjson.JSON;
import com.carton.mapper.AccountMapper;
import com.carton.model.Account;
import com.carton.model.AccountExample;
import com.carton.service.AccountService;
import com.carton.util.ApiHelper;
import com.carton.util.BaseBeanUtil;
import com.carton.util.LogExceptionStackTrace;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:54
 ************************************************************/

@SuppressWarnings("Duplicates")
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public PageInfo<Account> getAccountList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        try {
            logger.info(String.format("Retrieve AccountList by [pageNum = %s, pageSize = %s, params = %s]", pageNum, pageSize, JSON.toJSONString(params)));
            PageHelper.startPage(pageNum, pageSize);
            List<Account> accountList = accountMapper.selectByExample(handlerQueryParams(params));

            logger.info(String.format("AccountList is: %s", JSON.toJSONString(accountList)));

            return new PageInfo<>(accountList);

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new PageInfo<>();
        }
    }

    private AccountExample handlerQueryParams(Map<String, Object> params) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        if (params != null && !params.isEmpty()) {
            String nameParam = BaseBeanUtil.objectToString(params.get("nameParam"));
            if (StringUtils.isNotBlank(nameParam)) {
                criteria.andNameLike(nameParam);
            }
        }

        return accountExample;
    }

    @Override
    public Account getAccountById(Integer id) {
        try {
            return accountMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new Account();
        }
    }

    @Override
    public Result addAccount(Account account) {
        try {
            account.setValid(true);
            account.setCreateDate(new Date());
            accountMapper.insert(account);

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
        return ApiHelper.getSuccessResult();
    }

    @Override
    public Result editAccount(Account account) {
        try {
            Account updateAccount = accountMapper.selectByPrimaryKey(account.getId());
            if (updateAccount != null) {
                BeanUtils.copyProperties(account, updateAccount, "valid", "createDate", "createUser");

                updateAccount.setUpdateDate(new Date());
                accountMapper.updateByPrimaryKey(updateAccount);
                return ApiHelper.getSuccessResult();
            }
            return ApiHelper.getFailResult();

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
    }
}
