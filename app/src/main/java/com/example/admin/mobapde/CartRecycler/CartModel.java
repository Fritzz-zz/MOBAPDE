package com.example.admin.mobapde.CartRecycler;



//Not sure if we even need a model for the user
public class CartModel {
    private String sItemName;
    private float fPrice;
    private int nQuantity;
    private float fTotal;



    public CartModel(String name, float price, int quantity) {
        this.sItemName = name;
        this.fPrice = price;
        this.nQuantity = quantity;
    }


    public String getsItemName() {
        return sItemName;
    }

    public void setsItemName(String sItemName) {
        this.sItemName = sItemName;
    }

    public Float getfPrice() {
        return fPrice;
    }

    public void setfPrice(Float fPrice) {
        this.fPrice = fPrice;
    }

    public int getnQuantity() {
        return nQuantity;
    }

    public void setnQuantity(int nQuantity) {
        this.nQuantity = nQuantity;
    }
}
