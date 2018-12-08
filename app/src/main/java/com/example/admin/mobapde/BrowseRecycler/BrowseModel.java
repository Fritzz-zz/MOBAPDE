package com.example.admin.mobapde.BrowseRecycler;



//Not sure if we even need a model for the user
public class BrowseModel {
//    private String name;
//    private int img;
//    private float price;
//    private int qty;
//    private String details;

    private String ProdName;
    private String ProdImageUrl;
    private String ProdType;
    private float ProdPrice;
    private String ProdDesc;
    private int ProdQty;


    public BrowseModel(String Name, String ImageUrl, String Type, float Price, String Desc, int ProdQty){
        if(Name.trim().equals("")){
            Name = "No Name";
        }
        else if(Desc.trim().equals("")){
            Desc = "No Description";
        }
        else if(Price <= 0){
            Price = 0.0f;
        }

        setProdName(Name);
        setProdImageUrl(ImageUrl);
        setProdType(Type);
        setProdPrice(Price);
        setProdDesc(Desc);
        setProdQty(ProdQty);

    }

    public BrowseModel () {

    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getImg() {
//        return img;
//    }
//
//    public void setImg(int img) {
//        this.img = img;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//
//    public int getQty() {
//        return qty;
//    }
//
//    public void setQty(int qty) {
//        this.qty = qty;
//    }
//
//
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public String getProdImageUrl() {
        return ProdImageUrl;
    }

    public void setProdImageUrl(String prodImageUrl) {
        ProdImageUrl = prodImageUrl;
    }

    public String getProdType() {
        return ProdType;
    }

    public void setProdType(String prodType) {
        ProdType = prodType;
    }

    public float getProdPrice() {
        return ProdPrice;
    }

    public void setProdPrice(float prodPrice) {
        ProdPrice = prodPrice;
    }

    public String getProdDesc() {
        return ProdDesc;
    }

    public void setProdDesc(String prodDesc) {
        ProdDesc = prodDesc;
    }


    public int getProdQty() {
        return ProdQty;
    }

    public void setProdQty(int prodQty) {
        ProdQty = prodQty;
    }
}
