package com.carton.service.impl;

import com.alibaba.fastjson.JSON;
import com.carton.mapper.CartonCategoryMapper;
import com.carton.model.CartonCategory;
import com.carton.model.CartonCategoryExample;
import com.carton.service.CartonCategoryService;
import com.carton.util.ApiHelper;
import com.carton.util.BaseBeanUtil;
import com.carton.util.LogExceptionStackTrace;
import com.carton.vo.CartonCategoryVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class CartonCategoryServiceImpl implements CartonCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CartonCategoryServiceImpl.class);

    @Autowired
    private CartonCategoryMapper cartonCategoryMapper;

    @Override
    public PageInfo<CartonCategoryVO> getCartonCategoryList(Integer pageNum, Integer pageSize, Map<String, Object> params) {

        try {
            logger.info(String.format("Retrieve CartonCategoryList by [pageNum = %s, pageSize = %s, params = %s]", pageNum, pageSize, JSON.toJSONString(params)));
            PageHelper.startPage(pageNum, pageSize);

            CartonCategoryExample query = new CartonCategoryExample();
            List<CartonCategory> cartonCategoryList = cartonCategoryMapper.selectByExample(query);
            logger.info(String.format("CartonCategoryList is: %s", JSON.toJSONString(cartonCategoryList)));

            return new PageInfo<>(BaseBeanUtil.convertCartonCategoryList2VOs(cartonCategoryList));

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new PageInfo<>();
        }
    }

    @Override
    public CartonCategory getCartonCategoryDetail(Integer id) {

        try {
            return cartonCategoryMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new CartonCategory();
        }
    }

    @Override
    public Result addCartonCategory(CartonCategory cartonCategory) {

        try {
            cartonCategory.setValid(true);
            cartonCategory.setCreateDate(new Date());
            cartonCategoryMapper.insert(cartonCategory);

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
        return ApiHelper.getSuccessResult();
    }

    @Override
    public Result editCartonCategory(CartonCategory cartonCategory) {

        try {
            CartonCategory updateCartonCategory = cartonCategoryMapper.selectByPrimaryKey(cartonCategory.getId());
            if (updateCartonCategory != null) {
                BeanUtils.copyProperties(cartonCategory, updateCartonCategory, "valid", "createDate", "createUser");

                updateCartonCategory.setUpdateDate(new Date());
                cartonCategoryMapper.updateByPrimaryKey(updateCartonCategory);
                return ApiHelper.getSuccessResult();
            }
            return ApiHelper.getFailResult();

        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return ApiHelper.getFailResult();
        }
    }

}
