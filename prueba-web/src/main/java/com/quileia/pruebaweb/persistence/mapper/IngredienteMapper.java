package com.quileia.pruebaweb.persistence.mapper;


import com.quileia.pruebaweb.domain.Ingredient;
import com.quileia.pruebaweb.domain.Restaurant;
import com.quileia.pruebaweb.persistence.entity.Ingrediente;
import com.quileia.pruebaweb.persistence.entity.Restaurante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {MenuMapper.class})
public interface IngredienteMapper {

    @Mappings({
            @Mapping(source ="id_ingrediente",  target = "ingredientId"),
            @Mapping(source = "nombre",         target = "name_ingredient"),
            @Mapping(source ="calorias",        target= "calories"),
            //@Mapping(source="menus",            target = "menusI")


    })
    Ingredient toIngredient(Ingrediente ingrediente);
    List<Ingredient> toIngredients(List<Ingrediente> ingredientes);

    @InheritInverseConfiguration
    Ingrediente toIngrediente(Ingredient ingredient);
    List<Ingrediente> toIngredientes(List<Ingredient> ingredients);
}
