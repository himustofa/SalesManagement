package com.sm.demo.salesmanagement.suppliers;

import java.sql.Timestamp;

public class SuppliersModel {

    private String supplierId;
    private String supplierName;
    private String supplierCompanyName;
    private String supplierContactPerson;
    private String supplierPhoneNumber;
    private String supplierAddress;
    private String supplierBankName;
    private String supplierBankAccount;
    private String supplierEmail;
    private String supplierWebsite;
    private String supplierDescription;
    private String createdById;
    private String updatedById;
    private String createdAt;

    public SuppliersModel(String supplierId, String supplierName, String supplierCompanyName, String supplierContactPerson, String supplierPhoneNumber, String supplierAddress, String supplierBankName, String supplierBankAccount, String supplierEmail, String supplierWebsite, String supplierDescription, String createdById, String updatedById, String createdAt) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierCompanyName = supplierCompanyName;
        this.supplierContactPerson = supplierContactPerson;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierAddress = supplierAddress;
        this.supplierBankName = supplierBankName;
        this.supplierBankAccount = supplierBankAccount;
        this.supplierEmail = supplierEmail;
        this.supplierWebsite = supplierWebsite;
        this.supplierDescription = supplierDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public SuppliersModel(String supplierName, String supplierCompanyName, String supplierContactPerson, String supplierPhoneNumber, String supplierAddress, String supplierBankName, String supplierBankAccount, String supplierEmail, String supplierWebsite, String supplierDescription, String createdById, String updatedById, String createdAt) {
        this.supplierName = supplierName;
        this.supplierCompanyName = supplierCompanyName;
        this.supplierContactPerson = supplierContactPerson;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierAddress = supplierAddress;
        this.supplierBankName = supplierBankName;
        this.supplierBankAccount = supplierBankAccount;
        this.supplierEmail = supplierEmail;
        this.supplierWebsite = supplierWebsite;
        this.supplierDescription = supplierDescription;
        this.createdById = createdById;
        this.updatedById = updatedById;
        this.createdAt = createdAt;
    }

    public SuppliersModel(String supplierName, String supplierCompanyName, String supplierContactPerson, String supplierPhoneNumber, String supplierAddress, String supplierBankName, String supplierBankAccount, String supplierEmail, String supplierWebsite) {
        this.supplierName = supplierName;
        this.supplierCompanyName = supplierCompanyName;
        this.supplierContactPerson = supplierContactPerson;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierAddress = supplierAddress;
        this.supplierBankName = supplierBankName;
        this.supplierBankAccount = supplierBankAccount;
        this.supplierEmail = supplierEmail;
        this.supplierWebsite = supplierWebsite;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName;
    }

    public String getSupplierContactPerson() {
        return supplierContactPerson;
    }

    public void setSupplierContactPerson(String supplierContactPerson) {
        this.supplierContactPerson = supplierContactPerson;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierBankName() {
        return supplierBankName;
    }

    public void setSupplierBankName(String supplierBankName) {
        this.supplierBankName = supplierBankName;
    }

    public String getSupplierBankAccount() {
        return supplierBankAccount;
    }

    public void setSupplierBankAccount(String supplierBankAccount) {
        this.supplierBankAccount = supplierBankAccount;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierWebsite() {
        return supplierWebsite;
    }

    public void setSupplierWebsite(String supplierWebsite) {
        this.supplierWebsite = supplierWebsite;
    }

    public String getSupplierDescription() {
        return supplierDescription;
    }

    public void setSupplierDescription(String supplierDescription) {
        this.supplierDescription = supplierDescription;
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
