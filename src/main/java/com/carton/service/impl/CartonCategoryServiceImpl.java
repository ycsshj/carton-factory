package com.carton.service.impl;

import com.alibaba.fastjson.JSON;
import com.carton.mapper.CartonCategoryMapper;
import com.carton.model.CartonCategory;
import com.carton.model.CartonCategoryExample;
import com.carton.service.CartonCategoryService;
import com.carton.util.BaseBeanUtil;
import com.carton.vo.CartonCategoryVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:54
 ************************************************************/

@Service
public class CartonCategoryServiceImpl implements CartonCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CartonCategoryServiceImpl.class);

    @Autowired
    private CartonCategoryMapper cartonCategoryMapper;

    @Override
    public PageInfo<CartonCategoryVO> getCartonCategoryList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        logger.info(String.format("Retrieve CartonCategoryList by [pageNum = %s, pageSize = %s, params = %s]", pageNum, pageSize, JSON.toJSONString(params)));
        PageHelper.startPage(pageNum, pageSize);

        CartonCategoryExample query = new CartonCategoryExample();
        List<CartonCategory> cartonCategoryList = cartonCategoryMapper.selectByExample(query);
        logger.info(String.format("CartonCategoryList is: %s", JSON.toJSONString(params)));

        return new PageInfo<>(BaseBeanUtil.convertCartonCategoryList2VOs(cartonCategoryList));
    }
}
