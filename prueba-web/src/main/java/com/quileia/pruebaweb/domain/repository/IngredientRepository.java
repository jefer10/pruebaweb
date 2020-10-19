package com.quileia.pruebaweb.domain.repository;

import com.quileia.pruebaweb.domain.Ingredient;
import com.quileia.pruebaweb.domain.Menus;


import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    public List<Ingredient> getAll();
    public  List<Ingredient> getByCalorias(int calorias);
    public Optional<Ingredient> getByID(int Id);
    public Ingredient create(Ingredient ingredient);
    public void deleteByID(int id);
    public void updateByID(Ingredient ingredient);
    public List<Ingredient> saveAll(List<Ingredient> ingredientIterable);
}
