package com.example.admin.mobapde;

public class Product {

    private String productID;
    private String productModel;
    private String productBrand;
    private String productType;

    public Product(){

    }

    public Product(String productID, String productModel, String productBrand, String productType) {
        this.setProductID(productID);
        this.setProductModel(productModel);
        this.setProductBrand(productBrand);
        this.setProductType(productType);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
