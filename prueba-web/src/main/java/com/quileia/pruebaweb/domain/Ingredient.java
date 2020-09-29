package com.quileia.pruebaweb.domain;

import java.util.List;

public class Ingredient {

    private int  ingredientId;
    private String name_ingredient;
    private String calories;
    private List<Menus> menusI;


    public List<Menus> getMenusI() {
        return menusI;
    }

    public void setMenusI(List<Menus> menusI) {
        this.menusI = menusI;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName_ingredient() {
        return name_ingredient;
    }

    public void setName_ingredient(String name_ingredient) {
        this.name_ingredient = name_ingredient;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
