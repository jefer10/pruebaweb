package com.quileia.pruebaweb.persistence.mapper;


import com.quileia.pruebaweb.domain.Restaurant;
import com.quileia.pruebaweb.persistence.entity.Restaurante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Locale;

@Mapper(componentModel = "spring", uses = {MenuMapper.class})
public interface RestaurantMapper {

    @Mappings({
            //@Mapping(source = "id_restaurante",      target = "restaurantId"),//target es la salida, lo que transforma
            @Mapping(source = "razon_social",        target = "business_name"),
            @Mapping(source = "nombre_comercial",    target = "tradename"),
            @Mapping(source = "tipo_de_restaurante", target = "type_restaurant"),
            @Mapping(source = "ciudad",              target = "city"),
            @Mapping(source = "hora_apertura",       target = "opening_time"),
            @Mapping(source = "hora_cierre",         target = "closing_time"),
            @Mapping(source = "id_restaurante",      target= "restaurantId"),
            @Mapping(source = "menus",               target = "menusd")
            //@Mapping(source = "menus",               target = "menusd"),

    })
    Restaurant toRestaurant(Restaurante restaurante);
    List<Restaurant> toRestaurants(List<Restaurante> restaurantes);

    @InheritInverseConfiguration
    //@Mapping(target="menus", ignore = true)//ignora al atributo menus
    Restaurante toRestaurante(Restaurant restaurant);
    List<Restaurante> toRestaurantes(List<Restaurant> restaurants);
}
