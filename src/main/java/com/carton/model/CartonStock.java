package com.carton.model;

import java.util.Date;

public class CartonStock {

    private Integer id;

    private String name;

    private String cartonCategoryId;

    private Integer stock;

    private Integer stockLeft;

    private Double costPrice;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCartonCategoryId() {
        return cartonCategoryId;
    }

    public void setCartonCategoryId(String cartonCategoryId) {
        this.cartonCategoryId = cartonCategoryId == null ? null : cartonCategoryId.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(Integer stockLeft) {
        this.stockLeft = stockLeft;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
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