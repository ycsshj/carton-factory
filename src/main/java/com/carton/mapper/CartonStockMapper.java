package com.carton.mapper;

import com.carton.model.CartonStock;
import com.carton.model.CartonStockExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartonStockMapper {

    int countByExample(CartonStockExample example);

    int deleteByExample(CartonStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CartonStock record);

    int insertSelective(CartonStock record);

    List<CartonStock> selectByExample(CartonStockExample example);

    CartonStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CartonStock record, @Param("example") CartonStockExample example);

    int updateByExample(@Param("record") CartonStock record, @Param("example") CartonStockExample example);

    int updateByPrimaryKeySelective(CartonStock record);

    int updateByPrimaryKey(CartonStock record);
}