package com.quileia.pruebaweb.domain;

import java.util.List;

public class Ingredient {

    //propiedades de la entidad
    private int  ingredientId;
    private String name_ingredient;
    private Integer calories;




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

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
