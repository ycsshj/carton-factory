package com.carton.mapper;

import com.carton.model.Lov;
import com.carton.model.LovExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LovMapper {

    int countByExample(LovExample example);

    int deleteByExample(LovExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lov record);

    int insertSelective(Lov record);

    List<Lov> selectByExample(LovExample example);

    Lov selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lov record, @Param("example") LovExample example);

    int updateByExample(@Param("record") Lov record, @Param("example") LovExample example);

    int updateByPrimaryKeySelective(Lov record);

    int updateByPrimaryKey(Lov record);
}