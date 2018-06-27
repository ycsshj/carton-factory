package com.carton.model;

import com.carton.model.base.BaseEntity;

import java.util.Date;

public class CartonOrder extends BaseEntity {

    private Integer id;

    private String cartonStockId;

    private Integer amount;

    private Double salesPrice;

    private Date publishDate;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCartonStockId() {
        return cartonStockId;
    }

    public void setCartonStockId(String cartonStockId) {
        this.cartonStockId = cartonStockId == null ? null : cartonStockId.trim();
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}