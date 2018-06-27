package com.carton.service;

import com.carton.vo.LovVO;

import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:56
 ************************************************************/

public interface LovService {
    List<LovVO> getLovByCondition(String category, String parentCode, String lovCode);

    List<LovVO> batchInsertLov(List<LovVO> lovVOList);
}
