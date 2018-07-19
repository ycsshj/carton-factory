package com.carton.model;

import com.carton.model.base.BaseEntity;

public class CartonCategory extends BaseEntity {

    private String cartonBigType;

    private String cartonBigTypeValue;

    private String cartonSmallType;

    private String cartonSmallTypeValue;

    private Double cartonLength;

    private Double cartonWidth;

    private Double cartonHeight;

    private String cartonStandard;

    private String criticalStandard;

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

    public String getCartonBigTypeValue() {
        return cartonBigTypeValue;
    }

    public void setCartonBigTypeValue(String cartonBigTypeValue) {
        this.cartonBigTypeValue = cartonBigTypeValue;
    }

    public String getCartonSmallTypeValue() {
        return cartonSmallTypeValue;
    }

    public void setCartonSmallTypeValue(String cartonSmallTypeValue) {
        this.cartonSmallTypeValue = cartonSmallTypeValue;
    }
}