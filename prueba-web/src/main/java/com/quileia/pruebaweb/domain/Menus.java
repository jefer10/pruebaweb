package com.quileia.pruebaweb.domain;

import java.util.List;

public class Menus {

    //propiedades de la entidad
    private int menuId;
    private String type_menu;
    private String name_menu;
    private double price;
    private int restaurantId;

    //relaciones entre las entidades
    private List<Ingredient> ingredients;


    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getType_menu() {
        return type_menu;
    }

    public void setType_menu(String type_menu) {
        this.type_menu = type_menu;
    }

    public String getName_menu() {
        return name_menu;
    }

    public void setName_menu(String name_menu) {
        this.name_menu = name_menu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
