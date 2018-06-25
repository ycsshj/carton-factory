package com.carton.mapper;

import com.carton.model.CartonCategory;
import com.carton.model.CartonCategoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartonCategoryMapper {

    int countByExample(CartonCategoryExample example);

    int deleteByExample(CartonCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CartonCategory record);

    int insertSelective(CartonCategory record);

    List<CartonCategory> selectByExample(CartonCategoryExample example);

    CartonCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CartonCategory record, @Param("example") CartonCategoryExample example);

    int updateByExample(@Param("record") CartonCategory record, @Param("example") CartonCategoryExample example);

    int updateByPrimaryKeySelective(CartonCategory record);

    int updateByPrimaryKey(CartonCategory record);
}