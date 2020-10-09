package com.quileia.pruebaweb.domain;

import java.util.List;

public class Restaurant {

    //propiedades de la entidad
    private int restaurantId;
    private String business_name;//razon social
    private String tradename;//nombre comercial
    private int type_restaurant;
    private String city;
    private String opening_time;
    private String closing_time;

    //relaciones
    private List<Menus>menusd;

    //setter y getter

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public int getType_restaurant() {
        return type_restaurant;
    }

    public void setType_restaurant(int type_restaurant) {
        this.type_restaurant = type_restaurant;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public List<Menus> getMenusd() {
        return menusd;
    }

    public void setMenusd(List<Menus> menusd) {
        this.menusd = menusd;
    }
}
