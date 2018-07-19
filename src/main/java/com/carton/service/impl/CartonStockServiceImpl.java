package com.carton.service.impl;

import com.alibaba.fastjson.JSON;
import com.carton.mapper.CartonOrderMapper;
import com.carton.mapper.CartonStockMapper;
import com.carton.model.*;
import com.carton.service.CartonStockService;
import com.carton.util.ApiHelper;
import com.carton.util.BaseBeanUtil;
import com.carton.util.LogExceptionStackTrace;
import com.carton.vo.CartonStockVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:55
 ************************************************************/

@Transactional
@SuppressWarnings("Duplicates")
@Service
public class CartonStockServiceImpl implements CartonStockService {
    private static final Logger logger = LoggerFactory.getLogger(CartonCategoryServiceImpl.class);

    @Autowired
    private CartonStockMapper cartonStockMapper;

    @Autowired
    private CartonOrderMapper cartonOrderMapper;

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
            cartonStock.setStockLeft(cartonStock.getStock());
            cartonStockMapper.insert(cartonStock);

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
        return ApiHelper.getSuccessResult();
    }

    @Override
    public Result editCartonStock(CartonStock cartonStock) {
        Result result = new Result();
        try {
            CartonStock updateCartonStock = cartonStockMapper.selectByPrimaryKey(cartonStock.getId());

            if (updateCartonStock != null) {

                synchronized (String.valueOf(cartonStock.getId().intValue())) {
                    BeanUtils.copyProperties(cartonStock, updateCartonStock, "valid", "createDate", "createUser");

                    Integer stockOld = updateCartonStock.getStock();
                    Integer stockLeftOld = updateCartonStock.getStockLeft();
                    Integer stockNew = cartonStock.getStock();

                    if ((stockOld - stockLeftOld) > stockNew) {
                        result.setCode(Result.ERROR);
                        result.setMessage("库存数不能小于已经使用的库存数");
                        return result;
                    }

                    updateCartonStock.setStockLeft(stockNew - (stockOld - stockLeftOld));
                    updateCartonStock.setUpdateDate(new Date());
                    cartonStockMapper.updateByPrimaryKey(updateCartonStock);
                    return result;
                }
            }

            return ApiHelper.getFailResult();
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
    }

    @Override
    public List<Map<String, Object>> getSimpleCartonStockList() {
        PageInfo<CartonStock> pageInfo = getCartonStockList(1, 9999, null);
        List<CartonStock> cartonStockList = pageInfo.getList();
        List<Map<String, Object>> resultList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cartonStockList)) {
            for (CartonStock cartonStock : cartonStockList) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", cartonStock.getId());
                map.put("simpleName", cartonStock.getName() + "  总库存: " + cartonStock.getStock() + "  剩余库存: " + cartonStock.getStockLeft());
                resultList.add(map);
            }
        }

        return resultList;
    }
}
