package com.carton.service.impl;

import com.alibaba.fastjson.JSON;
import com.carton.mapper.*;
import com.carton.model.*;
import com.carton.service.CartonOrderService;
import com.carton.service.CartonStockService;
import com.carton.util.ApiHelper;
import com.carton.util.BaseBeanUtil;
import com.carton.util.LogExceptionStackTrace;
import com.carton.vo.CartonInfoVO;
import com.carton.vo.base.Result;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:55
 ************************************************************/

@Transactional
@SuppressWarnings("Duplicates")
@Service
public class CartonOrderServiceImpl implements CartonOrderService {
    private static final Logger logger = LoggerFactory.getLogger(CartonOrderServiceImpl.class);

    @Autowired
    private CartonOrderMapper cartonOrderMapper;

    @Autowired
    private CartonStockService cartonStockService;

    @Autowired
    private CartonStockMapper cartonStockMapper;

    @Autowired
    private CartonCategoryMapper cartonCategoryMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public PageInfo<CartonOrder> getCartonOrderList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        try {
            logger.info(String.format("Retrieve CartonOrderList by [pageNum = %s, pageSize = %s, params = %s]", pageNum, pageSize, JSON.toJSONString(params)));
            PageHelper.startPage(pageNum, pageSize);
            List<CartonOrder> cartonOrderList = cartonOrderMapper.selectByExample(handlerQueryParams(params));
            if (CollectionUtils.isNotEmpty(cartonOrderList)) {
                cartonOrderList.forEach(item -> {
                    Account account = accountMapper.selectByPrimaryKey(item.getAccountId());
                    item.setAccountName(account.getName());

                    CartonStock cartonStock = cartonStockMapper.selectByPrimaryKey(item.getCartonStockId());
                    item.setCartonStockName(cartonStock.getName());
                });
            }

            logger.info(String.format("CartonOrderList is: %s", JSON.toJSONString(cartonOrderList)));

            return new PageInfo<>(cartonOrderList);

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new PageInfo<>();
        }
    }

    private CartonOrderExample handlerQueryParams(Map<String, Object> params) {
        CartonOrderExample cartonOrderExample = new CartonOrderExample();
        CartonOrderExample.Criteria criteria = cartonOrderExample.createCriteria();
        if (params != null && !params.isEmpty()) {
            String nameParam = BaseBeanUtil.objectToString(params.get("nameParam"));
            if (StringUtils.isNotBlank(nameParam)) {
                criteria.andNameLike(nameParam);
            }
        }

        return cartonOrderExample;
    }

    @Override
    public CartonOrder getCartonOrderById(Integer id) {
        try {
            return cartonOrderMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new CartonOrder();
        }
    }

    @Override
    public Result addCartonOrder(CartonOrder cartonOrder) {
        Result result = new Result();
        try {

            CartonStock cartonStock = cartonStockService.getCartonStockDetail(cartonOrder.getCartonStockId());
            if (cartonStock == null) {
                result.setCode(Result.ERROR);
                result.setMessage("库存选择不能为空");
                return result;
            }

            Integer amount = cartonOrder.getAmount();       //下单数
            Integer stockLeft = cartonStock.getStockLeft(); //库存剩余数

            if (amount > stockLeft) {
                result.setCode(Result.ERROR);
                result.setMessage("库存不足, 请减少下单数量");
                return result;
            }

            //乐观锁方式减库存,防止并发扣库存
            cartonStock.setStockLeft(stockLeft - amount);
            CartonStockExample cartonStockExample = new CartonStockExample();
            CartonStockExample.Criteria criteria = cartonStockExample.createCriteria();
            criteria.andIdEqualTo(cartonStock.getId());
            criteria.andStockLeftEqualTo(stockLeft);

            int update = cartonStockMapper.updateByExample(cartonStock, cartonStockExample);
            if (update <= 0) {
                result.setCode(Result.ERROR);
                result.setMessage("新增订单失败, 请重新提交");
                return result;
            }

            cartonOrder.setValid(true);
            cartonOrder.setCreateDate(new Date());
            cartonOrderMapper.insert(cartonOrder);

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
        return result;
    }

    @Override
    public synchronized Result editCartonOrder(CartonOrder cartonOrder) {
        try {
            CartonOrder updateCartonOrder = cartonOrderMapper.selectByPrimaryKey(cartonOrder.getId());
            if (updateCartonOrder != null) {
                BeanUtils.copyProperties(cartonOrder, updateCartonOrder, "valid", "createDate", "createUser");

                updateCartonOrder.setUpdateDate(new Date());
                cartonOrderMapper.updateByPrimaryKey(updateCartonOrder);
                return ApiHelper.getSuccessResult();
            }
            return ApiHelper.getFailResult();

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
    }

    @Override
    public List<CartonInfoVO> getOrderInfo4DownLoad(Integer[] orderIds) {
        List<CartonInfoVO> cartonInfoVOList = new ArrayList<>();
        if (orderIds != null && orderIds.length > 0) {
            for (Integer orderId : orderIds) {
                CartonInfoVO cartonInfoVO = new CartonInfoVO();
                CartonOrder cartonOrder = cartonOrderMapper.selectByPrimaryKey(orderId);
                CartonStock cartonStock = cartonStockMapper.selectByPrimaryKey(cartonOrder.getCartonStockId());
                CartonCategory cartonCategory = cartonCategoryMapper.selectByPrimaryKey(cartonStock.getCartonCategoryId());
                Account account = accountMapper.selectByPrimaryKey(cartonOrder.getAccountId());

                cartonInfoVO.setAccountName(account.getName());
                cartonInfoVO.setPhone(account.getPhone());
                cartonInfoVO.setOrderName(cartonOrder.getName());
                cartonInfoVO.setAmount(cartonOrder.getAmount());
                cartonInfoVO.setSalesPrice(cartonOrder.getSalesPrice());
                cartonInfoVO.setPublishDate(cartonOrder.getPublishDate());
                cartonInfoVO.setComment(cartonOrder.getComment());

                cartonInfoVO.setStockName(cartonStock.getName());
                cartonInfoVO.setStock(cartonStock.getStock());
                cartonInfoVO.setStockLeft(cartonStock.getStockLeft());
                cartonInfoVO.setCostPrice(cartonStock.getCostPrice());

                cartonInfoVO.setCartonBigTypeValue(cartonCategory.getCartonBigTypeValue());
                cartonInfoVO.setCartonSmallTypeValue(cartonCategory.getCartonSmallTypeValue());
                cartonInfoVO.setCartonLength(cartonCategory.getCartonLength());
                cartonInfoVO.setCartonWidth(cartonCategory.getCartonWidth());
                cartonInfoVO.setCartonHeight(cartonCategory.getCartonHeight());
                cartonInfoVO.setCartonStandard(cartonCategory.getCartonStandard());
                cartonInfoVO.setCriticalStandard(cartonCategory.getCriticalStandard());

                cartonInfoVOList.add(cartonInfoVO);
            }
        }

        return cartonInfoVOList;
    }
}
