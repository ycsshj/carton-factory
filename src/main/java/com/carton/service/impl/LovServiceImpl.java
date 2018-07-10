package com.carton.service.impl;

import com.alibaba.fastjson.JSON;
import com.carton.mapper.LovMapper;
import com.carton.model.Lov;
import com.carton.model.LovExample;
import com.carton.service.LovService;
import com.carton.util.BaseBeanUtil;
import com.carton.util.LogExceptionStackTrace;
import com.carton.vo.LovVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-23 20:56
 ************************************************************/

@Service
public class LovServiceImpl implements LovService {
    private static final Logger logger = LoggerFactory.getLogger(LovServiceImpl.class);

    @Autowired
    private LovMapper lovMapper;

    public List<LovVO> getLovByCondition(String category, String parentCode, String lovCode) {
        List<Lov> lovList = null;
        try {
            logger.info(String.format("Retrieve LovList by [category = %s, parentCode = %s, lovCode = %s]", category, parentCode, lovCode));

            LovExample lovHandler = new LovExample();
            LovExample.Criteria criteria = lovHandler.createCriteria();

            if (StringUtils.isNotBlank(category)) {
                criteria.andCategoryEqualTo(category);
            }

            if (StringUtils.isNotBlank(parentCode)) {
                criteria.andParentCodeEqualTo(parentCode);
            } else {
                criteria.andParentCodeIsNull();
            }

            if (StringUtils.isNotBlank(lovCode)) {
                criteria.andLovCodeEqualTo(lovCode);
            }

            lovList = lovMapper.selectByExample(lovHandler);

            logger.info(String.format("LovList is: %s", JSON.toJSONString(lovList)));
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return new ArrayList<>();
        }

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
