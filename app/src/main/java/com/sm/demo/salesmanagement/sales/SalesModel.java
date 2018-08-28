package com.sm.demo.salesmanagement.sales;

import java.sql.Timestamp;

public class SalesModel {

    private String salesId;
    private String productName;
    private String productId;
    private int productQuantity;
    private int purchaseProductQuantity;
    private String customerName;
    private String customerId;
    private String salesDate;
    private double salesDiscount;
    private double salesVat;
    private double salesAmount;
    private double salesPayment;
    private double salesBalance;
    private String salesDescription;
    private String createdById;
    private String updatedById;
    private String createdAt;

    public SalesModel(String salesId, String productName, String productId, int productQuantity, int purchaseProductQuantity, String customerName, String customerId, String salesDate, double salesDiscount, double salesVat, double salesAmount, double salesPayment, double salesBalance, String salesDescription, String createdById, String updatedById, String createdAt) {
        this.salesId = salesId;
        this.productName = productName;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.purchaseProductQuantity = purchaseProductQuantity;
        this.customerName = customerName;
        this.customerId = customerId;
        this.salesDate = salesDate;
        this.salesDiscount = salesDiscount;
        this.salesVat = salesVat;
        this.salesAmount = salesAmount;
        this.salesPayment = salesPayment;
        this.salesBalance = salesBalance;
        this.salesDescription = salesDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public SalesModel(String productName, String productId, int productQuantity, int purchaseProductQuantity, String customerName, String customerId, String salesDate, double salesDiscount, double salesVat, double salesAmount, double salesPayment, double salesBalance, String salesDescription, String createdById, String updatedById, String createdAt) {
        this.productName = productName;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.purchaseProductQuantity = purchaseProductQuantity;
        this.customerName = customerName;
        this.customerId = customerId;
        this.salesDate = salesDate;
        this.salesDiscount = salesDiscount;
        this.salesVat = salesVat;
        this.salesAmount = salesAmount;
        this.salesPayment = salesPayment;
        this.salesBalance = salesBalance;
        this.salesDescription = salesDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public SalesModel(String productName, String productId, int productQuantity, int purchaseProductQuantity, String customerName, String customerId, String salesDate, double salesDiscount, double salesVat, double salesAmount, double salesPayment, double salesBalance, String salesDescription) {
        this.productName = productName;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.purchaseProductQuantity = purchaseProductQuantity;
        this.customerName = customerName;
        this.customerId = customerId;
        this.salesDate = salesDate;
        this.salesDiscount = salesDiscount;
        this.salesVat = salesVat;
        this.salesAmount = salesAmount;
        this.salesPayment = salesPayment;
        this.salesBalance = salesBalance;
        this.salesDescription = salesDescription;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getPurchaseProductQuantity() {
        return purchaseProductQuantity;
    }

    public void setPurchaseProductQuantity(int purchaseProductQuantity) {
        this.purchaseProductQuantity = purchaseProductQuantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public double getSalesDiscount() {
        return salesDiscount;
    }

    public void setSalesDiscount(double salesDiscount) {
        this.salesDiscount = salesDiscount;
    }

    public double getSalesVat() {
        return salesVat;
    }

    public void setSalesVat(double salesVat) {
        this.salesVat = salesVat;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public double getSalesPayment() {
        return salesPayment;
    }

    public void setSalesPayment(double salesPayment) {
        this.salesPayment = salesPayment;
    }

    public double getSalesBalance() {
        return salesBalance;
    }

    public void setSalesBalance(double salesBalance) {
        this.salesBalance = salesBalance;
    }

    public String getSalesDescription() {
        return salesDescription;
    }

    public void setSalesDescription(String salesDescription) {
        this.salesDescription = salesDescription;
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
