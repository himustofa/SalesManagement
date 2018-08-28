package com.sm.demo.salesmanagement.customers;

import java.sql.Timestamp;

public class CustomersModel {

    private String customerId;
    private String customerName;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerContactPerson;
    private double customerDiscount;
    private String customerAddress;
    private String customerDescription;
    private String createdById;
    private String updatedById;
    private String createdAt;

    public CustomersModel(String customerId, String customerName, String customerPhoneNumber, String customerEmail, String customerContactPerson, double customerDiscount, String customerAddress, String customerDescription, String createdById, String updatedById, String createdAt) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.customerContactPerson = customerContactPerson;
        this.customerDiscount = customerDiscount;
        this.customerAddress = customerAddress;
        this.customerDescription = customerDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public CustomersModel(String customerName, String customerPhoneNumber, String customerEmail, String customerContactPerson, double customerDiscount, String customerAddress, String customerDescription, String createdById, String updatedById, String createdAt) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.customerContactPerson = customerContactPerson;
        this.customerDiscount = customerDiscount;
        this.customerAddress = customerAddress;
        this.customerDescription = customerDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public CustomersModel(String customerName, String customerPhoneNumber, String customerEmail, String customerContactPerson, double customerDiscount, String customerAddress, String customerDescription) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.customerContactPerson = customerContactPerson;
        this.customerDiscount = customerDiscount;
        this.customerAddress = customerAddress;
        this.customerDescription = customerDescription;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerContactPerson() {
        return customerContactPerson;
    }

    public void setCustomerContactPerson(String customerContactPerson) {
        this.customerContactPerson = customerContactPerson;
    }

    public double getCustomerDiscount() {
        return customerDiscount;
    }

    public void setCustomerDiscount(double customerDiscount) {
        this.customerDiscount = customerDiscount;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
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
