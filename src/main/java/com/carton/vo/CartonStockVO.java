package com.carton.vo;

import com.carton.vo.base.BaseVO;

public class CartonStockVO extends BaseVO {

    private Integer id;

    private String name;

    private String cartonCategoryId;

    private Integer stock;

    private Integer stockLeft;

    private Double costPrice;

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
}