package com.example.admin.mobapde.CartRecycler;



//Not sure if we even need a model for the user
public class CartModel {
//    private String sItemName;
//    private float fPrice;
//    private int nQuantity;

    private String ProdName;
    private String ProdImageUrl;
    private String ProdType;
    private float ProdPrice;
    private String ProdDesc;
    private int ProdQty;
    private String cartID;

    public CartModel(String Name, String ImageUrl, String Type, float Price, String Desc, int ProdQty){
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


//    public CartModel(String name, float price, int quantity) {
//        this.sItemName = name;
//        this.fPrice = price;
//        this.nQuantity = quantity;
//    }

    public CartModel () {

    }


//    public String getsItemName() {
//        return sItemName;
//    }
//
//    public void setsItemName(String sItemName) {
//        this.sItemName = sItemName;
//    }
//
//    public Float getfPrice() {
//        return fPrice;
//    }
//
//    public void setfPrice(Float fPrice) {
//        this.fPrice = fPrice;
//    }
//
//    public int getnQuantity() {
//        return nQuantity;
//    }
//
//    public void setnQuantity(int nQuantity) {
//        this.nQuantity = nQuantity;
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

    public void setCartID(String string) {cartID = string;}

    public String getCartID() {return cartID;}
}
