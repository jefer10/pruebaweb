package com.quileia.pruebaweb.domain;

public class Menus {

    private int menuId;
    private String type_menu;
    private String name_menu;
    private double price;
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
