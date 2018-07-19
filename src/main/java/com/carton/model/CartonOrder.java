package com.carton.model;

import com.carton.model.base.BaseEntity;

public class CartonOrder extends BaseEntity {

    private Integer accountId;

    private String accountName;

    private String name;

    private Integer cartonStockId;

    private String cartonStockName;

    private Integer amount;

    private Double salesPrice;

    private String publishDate;

    private String comment;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCartonStockId() {
        return cartonStockId;
    }

    public void setCartonStockId(Integer cartonStockId) {
        this.cartonStockId = cartonStockId;
    }

    public String getCartonStockName() {
        return cartonStockName;
    }

    public void setCartonStockName(String cartonStockName) {
        this.cartonStockName = cartonStockName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}