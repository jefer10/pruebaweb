package com.quileia.pruebaweb.domain.repository;

import com.quileia.pruebaweb.domain.Ingredient;
import com.quileia.pruebaweb.domain.Menus;
import com.quileia.pruebaweb.persistence.crud.IngredienteCrudRepository;
import com.quileia.pruebaweb.persistence.entity.Ingrediente;
import com.quileia.pruebaweb.persistence.entity.Menu;
import com.quileia.pruebaweb.persistence.mapper.IngredienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepository implements IngredientRepository{

    @Autowired
    private IngredienteCrudRepository ingredienteCrudRepository;
    @Autowired
    private IngredienteMapper ingredienteMapper;


    @Override
    public List<Ingredient> getAll() {
        List<Ingrediente>ingredienteList=(List<Ingrediente>) ingredienteCrudRepository.findAll();
        List<Ingredient>ingredientList=ingredienteMapper.toIngredients(ingredienteList);
        return ingredientList;
    }

    @Override
    public List<Ingredient> getByCalorias(int calorias) {
        List<Ingrediente> ingredienteList=ingredienteCrudRepository.findByCaloria(calorias);
        List<Ingredient>  ingredientList=ingredienteMapper.toIngredients(ingredienteList);
        return ingredientList;
    }

    @Override
    public Optional<Ingredient> getByID(int Id)
    {
        Optional<Ingrediente>ingrediente=ingredienteCrudRepository.findById(Id);
           return ingrediente.map(res->ingredienteMapper.toIngredient(res));
    }

    @Override
    public Ingredient create(Ingredient ingredient)
    {
        Ingrediente ingredient1=ingredienteMapper.toIngrediente(ingredient);
        Ingrediente ingrediente=ingredienteCrudRepository.save(ingredient1);
        return ingredienteMapper.toIngredient(ingrediente);
    }

    @Override
    public void deleteByID(int id) {
        ingredienteCrudRepository.deleteById(id);
    }

    @Override
    public void updateByID(Ingredient ingredient) {
        Ingrediente ingrediente=ingredienteMapper.toIngrediente(ingredient);
        ingredienteCrudRepository.save(ingrediente);
    }
}
