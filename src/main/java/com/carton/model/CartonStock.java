package com.carton.model;

import com.carton.model.base.BaseEntity;

public class CartonStock extends BaseEntity {

    private Integer id;

    private String name;

    private Integer cartonCategoryId;

    private Integer stock;

    private Integer stockLeft;

    private Double costPrice;

    private CartonCategory cartonCategory;

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

    public Integer getCartonCategoryId() {
        return cartonCategoryId;
    }

    public void setCartonCategoryId(Integer cartonCategoryId) {
        this.cartonCategoryId = cartonCategoryId;
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

    public CartonCategory getCartonCategory() {
        return cartonCategory;
    }

    public void setCartonCategory(CartonCategory cartonCategory) {
        this.cartonCategory = cartonCategory;
    }
}