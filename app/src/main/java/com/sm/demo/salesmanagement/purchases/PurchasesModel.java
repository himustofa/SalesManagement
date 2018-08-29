package com.sm.demo.salesmanagement.purchases;

import java.sql.Timestamp;

public class PurchasesModel {

    private String purchaseId;
    private String productName;
    private String productId;
    private String supplierName;
    private String supplierId;
    private int purchaseProductQuantity;
    private double purchaseProductPrice;
    private String purchaseDate;
    private double purchaseAmount;
    private double purchasePayment;
    private double purchaseBalance;
    private String purchaseDescription;
    private String createdById;
    private String updatedById;
    private String createdAt;

    public PurchasesModel(String purchaseId, String productName, String productId, String supplierName, String supplierId, String purchaseDate, int purchaseProductQuantity, double purchaseProductPrice, double purchaseAmount, double purchasePayment, double purchaseBalance, String purchaseDescription, String createdById, String updatedById, String createdAt) {
        this.purchaseId = purchaseId;
        this.productName = productName;
        this.productId = productId;
        this.supplierName = supplierName;
        this.supplierId = supplierId;
        this.purchaseDate = purchaseDate;
        this.purchaseProductQuantity = purchaseProductQuantity;
        this.purchaseProductPrice = purchaseProductPrice;
        this.purchaseAmount = purchaseAmount;
        this.purchasePayment = purchasePayment;
        this.purchaseBalance = purchaseBalance;
        this.purchaseDescription = purchaseDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public PurchasesModel(String productName, String productId, String supplierName, String supplierId, String purchaseDate, int purchaseProductQuantity, double purchaseProductPrice, double purchaseAmount, double purchasePayment, double purchaseBalance, String purchaseDescription, String createdById, String updatedById, String createdAt) {
        this.productName = productName;
        this.productId = productId;
        this.supplierName = supplierName;
        this.supplierId = supplierId;
        this.purchaseDate = purchaseDate;
        this.purchaseProductQuantity = purchaseProductQuantity;
        this.purchaseProductPrice = purchaseProductPrice;
        this.purchaseAmount = purchaseAmount;
        this.purchasePayment = purchasePayment;
        this.purchaseBalance = purchaseBalance;
        this.purchaseDescription = purchaseDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public PurchasesModel(String productName, String productId, String supplierName, String supplierId, String purchaseDate, int purchaseProductQuantity, double purchaseProductPrice, double purchaseAmount, double purchasePayment, double purchaseBalance, String purchaseDescription) {
        this.productName = productName;
        this.productId = productId;
        this.supplierName = supplierName;
        this.supplierId = supplierId;
        this.purchaseDate = purchaseDate;
        this.purchaseProductQuantity = purchaseProductQuantity;
        this.purchaseProductPrice = purchaseProductPrice;
        this.purchaseAmount = purchaseAmount;
        this.purchasePayment = purchasePayment;
        this.purchaseBalance = purchaseBalance;
        this.purchaseDescription = purchaseDescription;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchaseProductQuantity() {
        return purchaseProductQuantity;
    }

    public void setPurchaseProductQuantity(int purchaseProductQuantity) {
        this.purchaseProductQuantity = purchaseProductQuantity;
    }

    public double getPurchaseProductPrice() {
        return purchaseProductPrice;
    }

    public void setPurchaseProductPrice(double purchaseProductPrice) {
        this.purchaseProductPrice = purchaseProductPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public double getPurchasePayment() {
        return purchasePayment;
    }

    public void setPurchasePayment(double purchasePayment) {
        this.purchasePayment = purchasePayment;
    }

    public double getPurchaseBalance() {
        return purchaseBalance;
    }

    public void setPurchaseBalance(double purchaseBalance) {
        this.purchaseBalance = purchaseBalance;
    }

    public String getPurchaseDescription() {
        return purchaseDescription;
    }

    public void setPurchaseDescription(String purchaseDescription) {
        this.purchaseDescription = purchaseDescription;
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
