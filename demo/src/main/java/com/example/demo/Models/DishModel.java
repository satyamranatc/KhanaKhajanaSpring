package com.example.demo.Models;

public class DishModel {
    
    private String name;
    private String description;
    private int price;
    private String image;
    
    public DishModel(String name, String description, int price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    
}
