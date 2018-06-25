package com.carton.model;

import java.util.Date;

public class CartonCategory {

    private Integer id;

    private String cartonBigType;

    private String cartonSmallType;

    private Double cartonLength;

    private Double cartonWidth;

    private Double cartonHeight;

    private String cartonStandard;

    private String criticalStandard;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    private Integer valid;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}