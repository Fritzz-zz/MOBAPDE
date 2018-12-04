package com.example.admin.mobapde.FeaturedRecycler;



//Not sure if we even need a model for the user
public class FeaturedModel {
    private String name;
    private int img;


    public FeaturedModel(String name, int img) {
        this.setName(name);
        this.setImg(img);

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


}
