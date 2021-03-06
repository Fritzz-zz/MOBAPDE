package com.example.admin.mobapde.FeaturedRecycler;



//Not sure if we even need a model for the user
public class FeaturedModel {
//    private String name;
//    private int img;
//    private String imageUrl;

    private String ProdName;
    private String ProdImageUrl;
    private String ProdType;
    private float ProdPrice;
    private String ProdDesc;
    private int ProdQty;


    public FeaturedModel(String Name, String ImageUrl, String Type, float Price, String Desc, int ProdQty) {
        setProdName(Name);
        setProdImageUrl(ImageUrl);
        setProdType(Type);
        setProdPrice(Price);
        setProdDesc(Desc);
        setProdQty(ProdQty);
    }

    public FeaturedModel () {

    }

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
