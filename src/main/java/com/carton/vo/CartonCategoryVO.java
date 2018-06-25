package com.carton.vo;

import com.carton.vo.base.BaseVO;

public class CartonCategoryVO extends BaseVO {

    private Integer id;

    //纸箱大类(eg:卡通箱,床箱,纸片), 存lov_code
    private String cartonBigType;

    //纸箱小类(eg:三层,五层,办公台,中封), 存lov_code
    private String cartonSmallType;

    //纸箱长
    private Double cartonLength;

    //纸箱宽
    private Double cartonWidth;

    //纸箱高
    private Double cartonHeight;

    //材料规格
    private String cartonStandard;

    //压线规格
    private String criticalStandard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCartonBigType() {
        return cartonBigType;
    }

    public void setCartonBigType(String cartonBigType) {
        this.cartonBigType = cartonBigType == null ? null : cartonBigType.trim();
    }

    public String getCartonSmallType() {
        return cartonSmallType;
    }

    public void setCartonSmallType(String cartonSmallType) {
        this.cartonSmallType = cartonSmallType == null ? null : cartonSmallType.trim();
    }

    public Double getCartonLength() {
        return cartonLength;
    }

    public void setCartonLength(Double cartonLength) {
        this.cartonLength = cartonLength;
    }

    public Double getCartonWidth() {
        return cartonWidth;
    }

    public void setCartonWidth(Double cartonWidth) {
        this.cartonWidth = cartonWidth;
    }

    public Double getCartonHeight() {
        return cartonHeight;
    }

    public void setCartonHeight(Double cartonHeight) {
        this.cartonHeight = cartonHeight;
    }

    public String getCartonStandard() {
        return cartonStandard;
    }

    public void setCartonStandard(String cartonStandard) {
        this.cartonStandard = cartonStandard == null ? null : cartonStandard.trim();
    }

    public String getCriticalStandard() {
        return criticalStandard;
    }

    public void setCriticalStandard(String criticalStandard) {
        this.criticalStandard = criticalStandard == null ? null : criticalStandard.trim();
    }
}