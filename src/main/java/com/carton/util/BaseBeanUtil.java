package com.carton.util;

import com.carton.model.CartonCategory;
import com.carton.model.Lov;
import com.carton.vo.CartonCategoryVO;
import com.carton.vo.LovVO;
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

    public static List<LovVO> convertLovList2VOs(List<Lov> lovList) {
        List<LovVO> lovVOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(lovList)) {
            lovList.forEach(item -> lovVOList.add(convertLov2VO(item)));
        }
        return lovVOList;
    }

    public static LovVO convertLov2VO(Lov lov) {
        LovVO lovVO = new LovVO();
        if (lov != null) {
            BeanUtils.copyProperties(lov, lovVO);
        }
        return lovVO;
    }

    public static List<Lov> convertLovVOs2Entities(List<LovVO> lovVOList) {
        List<Lov> lovList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(lovVOList)) {
            lovVOList.forEach(item -> lovList.add(convertLovVO2Entity(item)));
        }
        return lovList;
    }

    private static Lov convertLovVO2Entity(LovVO lovVO) {
        Lov lov = new Lov();
        if (lovVO != null) {
            BeanUtils.copyProperties(lovVO, lov);
        }
        return lov;
    }

    public static CartonCategory convertCartonCategoryVO2Entity(CartonCategoryVO cartonCategoryVO) {
        CartonCategory cartonCategory = new CartonCategory();
        if (cartonCategoryVO != null) {
            BeanUtils.copyProperties(cartonCategoryVO, cartonCategory);
        }
        return cartonCategory;
    }
}
