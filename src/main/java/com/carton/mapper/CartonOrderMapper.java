package com.carton.mapper;

import com.carton.model.CartonOrder;
import com.carton.model.CartonOrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartonOrderMapper {

    int countByExample(CartonOrderExample example);

    int deleteByExample(CartonOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CartonOrder record);

    int insertSelective(CartonOrder record);

    List<CartonOrder> selectByExample(CartonOrderExample example);

    CartonOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CartonOrder record, @Param("example") CartonOrderExample example);

    int updateByExample(@Param("record") CartonOrder record, @Param("example") CartonOrderExample example);

    int updateByPrimaryKeySelective(CartonOrder record);

    int updateByPrimaryKey(CartonOrder record);
}