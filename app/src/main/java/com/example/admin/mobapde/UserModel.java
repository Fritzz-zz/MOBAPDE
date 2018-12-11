package com.example.admin.mobapde;

import com.example.admin.mobapde.CartRecycler.CartModel;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private String UserEmail;
    private float UserMoney;
    private List<CartModel> userCart;
    private String userID;


    public UserModel(String Email, float Price, ArrayList<CartModel> cart, String id) {
        setUserEmail(Email);
        setUserMoney(Price);
        setUserCart(cart);
        setUserID(id);
    }

    public UserModel () {

    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }


    public float getUserMoney() {
        return UserMoney;
    }

    public void setUserMoney(float userMoney) {
        UserMoney = userMoney;
    }


    public List<CartModel> getUserCart() {
        return userCart;
    }

    public void setUserCart(List<CartModel> userCart) {
        this.userCart = userCart;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
