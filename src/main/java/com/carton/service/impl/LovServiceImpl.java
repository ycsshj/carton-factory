package com.carton.service.impl;

import com.carton.mapper.LovMapper;
import com.carton.model.Lov;
import com.carton.model.LovExample;
import com.carton.service.LovService;
import com.carton.util.BaseBeanUtil;
import com.carton.vo.LovVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:56
 ************************************************************/

@Service
public class LovServiceImpl implements LovService {

    @Autowired
    private LovMapper lovMapper;

    public List<LovVO> getLovByCondition(String category, String parentCode, String lovCode) {
        LovExample lovHandler = new LovExample();
        LovExample.Criteria criteria = lovHandler.createCriteria();

        if (StringUtils.isNotBlank(category)) {
            criteria.andCategoryEqualTo(category);
        }

        if (StringUtils.isNotBlank(parentCode)) {
            criteria.andParentCodeEqualTo(parentCode);
        }else {
            criteria.andParentCodeIsNull();
        }

        if (StringUtils.isNotBlank(lovCode)) {
            criteria.andLovCodeEqualTo(lovCode);
        }

        List<Lov> lovList = lovMapper.selectByExample(lovHandler);
        return BaseBeanUtil.convertLovList2VOs(lovList);
    }

    public List<LovVO> batchInsertLov(List<LovVO> lovVOList) {
        if (CollectionUtils.isNotEmpty(lovVOList)) {
            List<Lov> lovList = BaseBeanUtil.convertLovVOs2Entities(lovVOList);
            lovList.forEach(item -> lovMapper.insert(item));
        }
        return lovVOList;
    }

}
