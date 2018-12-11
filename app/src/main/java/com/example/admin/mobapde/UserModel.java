package com.example.admin.mobapde;

public class UserModel {

    private String UserEmail;
    private float ProdPrice;


    public UserModel(String Email, float Price) {
        setUserEmail(Email);
        setProdPrice(Price);
    }

    public UserModel () {

    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public float getProdPrice() {
        return ProdPrice;
    }

    public void setProdPrice(float prodPrice) {
        ProdPrice = prodPrice;
    }
}
