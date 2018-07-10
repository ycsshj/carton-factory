package com.carton.service.impl;

import com.alibaba.fastjson.JSON;
import com.carton.mapper.CartonStockMapper;
import com.carton.model.CartonCategoryExample;
import com.carton.model.CartonStock;
import com.carton.model.CartonStockExample;
import com.carton.service.CartonStockService;
import com.carton.util.ApiHelper;
import com.carton.util.BaseBeanUtil;
import com.carton.util.LogExceptionStackTrace;
import com.carton.vo.CartonStockVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.Page;
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
 * @Date 2018-06-23 20:55
 ************************************************************/

@SuppressWarnings("Duplicates")
@Service
public class CartonStockServiceImpl implements CartonStockService {
    private static final Logger logger = LoggerFactory.getLogger(CartonCategoryServiceImpl.class);

    @Autowired
    private CartonStockMapper cartonStockMapper;

    @Override
    public PageInfo<CartonStock> getCartonStockList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        try {
            logger.info(String.format("Retrieve CartonStockList by [pageNum = %s, pageSize = %s, params = %s]", pageNum, pageSize, JSON.toJSONString(params)));

            PageHelper.startPage(pageNum, pageSize);
            List<CartonStock> cartonStockList = cartonStockMapper.selectByExample(handlerQueryParams(params));

            logger.info(String.format("CartonStockList is: %s", JSON.toJSONString(cartonStockList)));

            return new PageInfo<>(cartonStockList);
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new PageInfo<>();
        }
    }

    private CartonStockExample handlerQueryParams(Map<String, Object> params) {
        CartonStockExample query = new CartonStockExample();
        CartonStockExample.Criteria criteria = query.createCriteria();

        if (params != null) {
            String cartonCategoryParam = BaseBeanUtil.objectToString(params.get("cartonCategoryParam"));
            if (StringUtils.isNotBlank(cartonCategoryParam)) {
                criteria.andCartonCategoryIdEqualTo(cartonCategoryParam);
            }
            String nameParam = BaseBeanUtil.objectToString(params.get("nameParam"));
            if (StringUtils.isNotBlank(nameParam)) {
                criteria.andNameLike(nameParam);
            }
        }

        return query;
    }

    @Override
    public CartonStock getCartonStockDetail(Integer id) {

        try {
            return cartonStockMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new CartonStock();
        }
    }

    @Override
    public Result addCartonStock(CartonStock cartonStock) {
        try {
            cartonStock.setValid(true);
            cartonStock.setCreateDate(new Date());
            cartonStockMapper.insert(cartonStock);

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
        return ApiHelper.getSuccessResult();
    }

    @Override
    public Result editCartonStock(CartonStock cartonStock) {
        try {
            CartonStock updateCartonStock = cartonStockMapper.selectByPrimaryKey(cartonStock.getId());
            if (updateCartonStock != null) {
                BeanUtils.copyProperties(cartonStock, updateCartonStock, "valid", "createDate", "createUser");

                updateCartonStock.setUpdateDate(new Date());
                cartonStockMapper.updateByPrimaryKey(updateCartonStock);
                return ApiHelper.getSuccessResult();
            }
            return ApiHelper.getFailResult();

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
    }
}
