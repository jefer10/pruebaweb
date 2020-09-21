package com.quileia.pruebaweb.persistence.mapper;


import com.quileia.pruebaweb.domain.Menus;
import com.quileia.pruebaweb.persistence.entity.Menu;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    @Mappings({
            @Mapping(source = "id_menu",     target = "menuId"),
            @Mapping(source = "tipo_menu",   target = "type_menu"),
            @Mapping(source = "nombre_menu", target = "name_menu"),
            @Mapping(source = "precio",      target = "price"),
            @Mapping(source = "restaurante", target = "restaurant")
    })
    Menus toMenus(Menu menu);

    @InheritInverseConfiguration
    //@Mapping(target = "restaurante", ignore = true)
    @Mapping(target = "ingredientes",ignore = true)
    Menu toMenu(Menus menus);


}
