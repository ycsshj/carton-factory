package com.carton.util;

import com.carton.model.CartonCategory;
import com.carton.vo.CartonCategoryVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-22 8:58
 ************************************************************/
public class BaseBeanUtil {

    public static List<CartonCategoryVO> convertCartonCategoryList2VOs(List<CartonCategory> cartonCategoryList) {
        List<CartonCategoryVO> cartonCategoryVOS = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cartonCategoryList)) {
            cartonCategoryList.forEach(item -> cartonCategoryVOS.add(convertCartonCategory2VO(item)));
        }
        return cartonCategoryVOS;
    }

    public static CartonCategoryVO convertCartonCategory2VO(CartonCategory cartonCategory) {
        CartonCategoryVO cartonCategoryVO = new CartonCategoryVO();
        if (cartonCategory != null) {
            BeanUtils.copyProperties(cartonCategory, cartonCategoryVO);
        }
        return cartonCategoryVO;
    }
}
