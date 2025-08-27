package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.DishModel;
import com.example.demo.Models.RestaurantModel;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/restaurant")
public class RestaurantController {

    ArrayList <RestaurantModel> restaurants = new ArrayList<RestaurantModel>();

    public  RestaurantController()
    {

        RestaurantModel ApnaSweets = new RestaurantModel("Apna Sweets", "Indore", 12312, "https://content.jdmagicbox.com/comp/indore/e5/0731px731.x731.180101103317.q3e5/catalogue/apna-sweets-new-palasiya-new-palasia-indore-restaurants-1w2lh.jpg", "Apna Sweets is a well-known, multi-location sweet shop and restaurant chain in Indore. It is a popular spot for both locals and visitors, famous for its wide variety of traditional Indian sweets, savory snacks (namkeen), and vegetarian meals.");
        ApnaSweets.addDishes(new DishModel("Gulab Jamun", "Delicious", 100, "https://5.imimg.com/data5/SELLER/Default/2024/2/384944363/DN/MV/KT/144303146/gulab-jamun-desi-ghee.jpg"));
        ApnaSweets.addDishes(new DishModel("Pohe", "Delicious", 25, "https://madhurasrecipe.com/wp-content/uploads/2023/07/Kande-Pohe-Featured.jpg"));
        restaurants.add(ApnaSweets);




        RestaurantModel ShreeMaya = new RestaurantModel("Shree Maya", "Indore", 92018, "https://media-cdn.tripadvisor.com/media/photo-s/02/25/c1/b7/shreemaya-hotel.jpg", "The Shreemaya Group in Indore operates multiple hotels, restaurants, cafes, and bakeries known for their hospitality and food. The two primary hotel locations are on RNT Marg and AB Road. ");
        ShreeMaya.addDishes(new DishModel("Chole Bhature", "Delicious", 100, "https://www.vegrecipesofindia.com/wp-content/uploads/2019/02/chole-bhature.jpg"));
        restaurants.add(ShreeMaya); 
    }

    @GetMapping("/list")
    public List<RestaurantModel> getRestaurants() {
        return restaurants;
    }

    @GetMapping("/getOne/{name}")
    public RestaurantModel getRestaurantsById(@PathVariable String name) {
        System.out.println("----------------------");
        System.out.println(name);
        System.out.println("----------------------");
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().equals(name)) {
                return restaurants.get(i);
            }
        }
        return null;
    }

    @PostMapping("/add")
    public String addRestaurant(@RequestBody RestaurantModel restaurant) {
        restaurants.add(restaurant);
         return "Restaurant Added Successfully!"; 
    }
    @PostMapping("/add/dish/{resName}")
    public String addDish(@PathVariable String resName, @RequestBody DishModel dish) {
        for(RestaurantModel r : restaurants)
        {
            if(resName.equalsIgnoreCase(r.name))
            {
                r.addDishes(dish);
                return "Dish Added Successfully in "+r.name;
            }
        }
        return "Cant Find The Name of this Restaurant!";

    }

    
}