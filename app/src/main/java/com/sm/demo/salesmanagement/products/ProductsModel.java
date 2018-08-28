package com.sm.demo.salesmanagement.products;

import java.sql.Timestamp;

public class ProductsModel {

    private String productId;
    private String productName;
    private String productCode;
    private int productQuantity;
    private double productPrice;
    private String productExpireDate;
    private String productDescription;
    private String createdById;
    private String updatedById;
    private String createdAt;

    public ProductsModel(String productId, String productName, String productCode, int productQuantity, double productPrice, String productExpireDate, String productDescription, String createdById, String updatedById, String createdAt) {
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productExpireDate = productExpireDate;
        this.productDescription = productDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public ProductsModel(String productName, String productCode, int productQuantity, double productPrice, String productExpireDate, String productDescription, String createdById, String updatedById, String createdAt) {
        this.productName = productName;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productExpireDate = productExpireDate;
        this.productDescription = productDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public ProductsModel(String productName, String productCode, int productQuantity, double productPrice, String productExpireDate, String productDescription) {
        this.productName = productName;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productExpireDate = productExpireDate;
        this.productDescription = productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductExpireDate() {
        return productExpireDate;
    }

    public void setProductExpireDate(String productExpireDate) {
        this.productExpireDate = productExpireDate;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(String updatedById) {
        this.updatedById = updatedById;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
