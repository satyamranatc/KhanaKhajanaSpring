package com.example.demo.Models;

import java.util.ArrayList;
import java.util.List;

public class RestaurantModel {

    public String name;
    public String city;
    public int phone;
    public String poster;
    public String description;
    public List <DishModel> dishes = new ArrayList<DishModel>();

    public RestaurantModel(String name, String city, int phone, String poster, String description) {
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.poster = poster;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DishModel> getDishes() {
        return dishes;
    }

    public void addDishes(DishModel dish) {
        this.dishes.add(dish);
    }

    
}
