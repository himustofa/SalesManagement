package com.sm.demo.salesmanagement.profiles;

import java.sql.Timestamp;

public class ProfilesModel {

    private int companyId;
    private String companyName;
    private String companyEmail;
    private String companyPhoneNumber;
    private String companyAddress;
    private String companyLogoName;
    private String companyLogoPath;
    private byte[] logoData;
    private String timeZone;
    private String country;
    private String dateFormat;
    private String currencyFormat;
    private String createdById;
    private String updatedById;
    private Timestamp createdAt;

    public ProfilesModel(int companyId, String companyName, String companyEmail, String companyPhoneNumber, String companyAddress, String companyLogoName, String companyLogoPath) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyAddress = companyAddress;
        this.companyLogoName = companyLogoName;
        this.companyLogoPath = companyLogoPath;
    }

    public ProfilesModel(String companyName, String companyEmail, String companyPhoneNumber, String companyAddress, String companyLogoName, String companyLogoPath) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyAddress = companyAddress;
        this.companyLogoName = companyLogoName;
        this.companyLogoPath = companyLogoPath;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyLogoName() {
        return companyLogoName;
    }

    public void setCompanyLogoName(String companyLogoName) {
        this.companyLogoName = companyLogoName;
    }

    public String getCompanyLogoPath() {
        return companyLogoPath;
    }

    public void setCompanyLogoPath(String companyLogoPath) {
        this.companyLogoPath = companyLogoPath;
    }

    public byte[] getLogoData() {
        return logoData;
    }

    public void setLogoData(byte[] logoData) {
        this.logoData = logoData;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getCurrencyFormat() {
        return currencyFormat;
    }

    public void setCurrencyFormat(String currencyFormat) {
        this.currencyFormat = currencyFormat;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
