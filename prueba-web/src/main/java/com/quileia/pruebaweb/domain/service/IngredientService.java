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
    public Boolean deleteByID(int id){
        if (getByID(id).isPresent()){
            ingredientRepository.deleteByID(id);
            return true;
        }else {
            return false;
        }
    }
    public Boolean updateByID(Ingredient ingredient){
        ingredientRepository.updateByID(ingredient);
        Optional<Ingredient>ingredient1=getByID(ingredient.getIngredientId());
        return ingredient1.map(rest -> {
            if (rest.toString().equals(ingredient1.toString())){
                return true;
            }else {
                return false;
            }
        }).orElse(false);
    }


}
