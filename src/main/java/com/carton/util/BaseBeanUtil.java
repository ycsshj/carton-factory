package com.carton.util;

import com.carton.model.*;
import com.carton.vo.*;
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

    public static String objectToString(Object obj) {
        return obj == null ? null : String.valueOf(obj);
    }

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

    public static List<CartonStockVO> convertCartonStockList2VOs(List<CartonStock> cartonStockList) {
        List<CartonStockVO> cartonStockVOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cartonStockList)) {
            cartonStockList.forEach(item -> cartonStockVOList.add(convertCartonStock2VO(item)));
        }
        return cartonStockVOList;
    }

    public static CartonStockVO convertCartonStock2VO(CartonStock cartonStock) {
        CartonStockVO cartonStockVO = new CartonStockVO();
        if (cartonStock != null) {
            BeanUtils.copyProperties(cartonStock, cartonStockVO);
        }
        return cartonStockVO;
    }

    public static CartonStock convertCartonStockVO2Entity(CartonStockVO cartonStockVO) {
        CartonStock cartonStock = new CartonStock();
        if (cartonStockVO != null) {
            BeanUtils.copyProperties(cartonStockVO, cartonStock);
        }
        return cartonStock;
    }

    public static AccountVO convertAccount2VO(Account account) {
        AccountVO accountVO = new AccountVO();
        if (account != null) {
            BeanUtils.copyProperties(account, accountVO);
        }
        return accountVO;
    }

    public static List<AccountVO> convertAccountList2VOs(List<Account> accountList) {
        List<AccountVO> accountVOS = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(accountList)) {
            accountList.forEach(item -> accountVOS.add(convertAccount2VO(item)));
        }
        return accountVOS;
    }

    public static Account convertAccountVO2Entity(AccountVO accountVO) {
        Account account = new Account();
        if (accountVO != null) {
            BeanUtils.copyProperties(accountVO, account);
        }
        return account;
    }

    public static List<CartonOrderVO> convertCartonOrderList2VOs(List<CartonOrder> cartonOrders) {
        List<CartonOrderVO> cartonOrderVOS = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cartonOrders)) {
            cartonOrders.forEach(item -> cartonOrderVOS.add(convertCartonOrder2VO(item)));
        }
        return cartonOrderVOS;
    }

    public static CartonOrderVO convertCartonOrder2VO(CartonOrder cartonOrder) {
        CartonOrderVO cartonOrderVO = new CartonOrderVO();
        if (cartonOrder != null) {
            BeanUtils.copyProperties(cartonOrder, cartonOrderVO);
        }
        return cartonOrderVO;
    }

    public static CartonOrder convertCartonOrderVO2Entity(CartonOrderVO cartonOrderVO) {
        CartonOrder cartonOrder = new CartonOrder();
        if (cartonOrderVO != null) {
            BeanUtils.copyProperties(cartonOrderVO, cartonOrder);
        }
        return cartonOrder;
    }
}
