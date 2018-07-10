package com.carton.vo;

import com.carton.vo.base.BaseVO;

import java.util.Date;

public class CartonOrderVO extends BaseVO {

    private Integer id;

    private Integer cartonStockId;

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

    public Integer getCartonStockId() {
        return cartonStockId;
    }

    public void setCartonStockId(Integer cartonStockId) {
        this.cartonStockId = cartonStockId;
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