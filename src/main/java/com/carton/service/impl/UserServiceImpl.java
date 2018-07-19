package com.carton.service.impl;

import com.carton.mapper.UserMapper;
import com.carton.model.User;
import com.carton.model.UserExample;
import com.carton.service.UserService;
import com.carton.util.LogExceptionStackTrace;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:56
 ************************************************************/

@Transactional
@Service
public class UserServiceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User validateUser(String userName, String passWord) {
        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserNameEqualTo(userName);
            criteria.andPasswordEqualTo(passWord);
            List<User> users = userMapper.selectByExample(userExample);

            return CollectionUtils.isNotEmpty(users) ? users.get(0) : null;
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return null;
        }
    }
}
