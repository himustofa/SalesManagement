package com.sm.demo.salesmanagement.users;

import java.sql.Timestamp;

public class UsersModel {

    private int userId;
    private String fullName;
    private String designation;
    private String email;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;
    private String photoName;
    private String photoPath;
    private String createdById;
    private String updatedById;
    private Timestamp createdAt;

    public UsersModel() {
    }

    public UsersModel(String username, String password, String photoName, String photoPath) {
        this.username = username;
        this.password = password;
        this.photoName = photoName;
        this.photoPath = photoPath;
    }

    public UsersModel(int userId, String fullName, String designation, String email, String phoneNumber, String address, String username, String password, String photoName, String photoPath) {
        this.userId = userId;
        this.fullName = fullName;
        this.designation = designation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.photoName = photoName;
        this.photoPath = photoPath;
    }

    public UsersModel(String fullName,
                      String designation,
                      String email,
                      String phoneNumber,
                      String address,
                      String username,
                      String password,
                      String photoName,
                      String photoPath) {
        this.fullName = fullName;
        this.designation = designation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.photoName = photoName;
        this.photoPath = photoPath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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
