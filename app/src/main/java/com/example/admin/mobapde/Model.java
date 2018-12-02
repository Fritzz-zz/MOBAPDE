package com.example.admin.mobapde;


//Model for each product in the recycler view
//Not sure if we even need a model for the user
public class Model {
    private String name;
    private int img;
    private float price;
    private int qty;

    public Model (String name, int img, float price, int qty) {
        this.setName(name);
        this.setImg(img);
        this.setPrice(price);
        this.setQty(qty);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
