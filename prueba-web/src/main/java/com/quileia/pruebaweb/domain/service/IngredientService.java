package com.quileia.pruebaweb.domain.service;

import com.quileia.pruebaweb.domain.Ingredient;
import com.quileia.pruebaweb.domain.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> getAll(){
        return ingredientRepository.getAll();
    }
    public  List<Ingredient> getByCalorias(int calorias){
        return ingredientRepository.getByCalorias(calorias);
    }
    public Optional<Ingredient> getByID(int Id){
        return ingredientRepository.getByID(Id);
    }
    public Ingredient create(Ingredient ingredient){
        return ingredientRepository.create(ingredient);
    }
    public void deleteByID(int id){
        ingredientRepository.deleteByID(id);
    }
    public void updateByID(Ingredient ingredient){
        ingredientRepository.updateByID(ingredient);
    }


}
