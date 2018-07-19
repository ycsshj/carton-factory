package com.carton.vo;

public class CartonInfoVO {

    /********************cartonOrder****************/
    private String accountName;
    private String phone;
    private String orderName;
    private Integer amount;
    private Double salesPrice;
    private String publishDate;
    private String comment;

    /********************cartonStock****************/
    private String stockName;
    private Integer stock;
    private Integer stockLeft;
    private Double costPrice;

    /********************cartonCategory****************/
    private String cartonBigTypeValue;
    private String cartonSmallTypeValue;
    private Double cartonLength;
    private Double cartonWidth;
    private Double cartonHeight;
    private String cartonStandard;
    private String criticalStandard;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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
        this.comment = comment;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
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
        this.cartonStandard = cartonStandard;
    }

    public String getCriticalStandard() {
        return criticalStandard;
    }

    public void setCriticalStandard(String criticalStandard) {
        this.criticalStandard = criticalStandard;
    }
}