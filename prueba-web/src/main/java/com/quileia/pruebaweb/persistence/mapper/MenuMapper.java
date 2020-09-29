package com.quileia.pruebaweb.persistence.mapper;


import com.quileia.pruebaweb.domain.Menus;
import com.quileia.pruebaweb.domain.Restaurant;
import com.quileia.pruebaweb.persistence.entity.Menu;
import com.quileia.pruebaweb.persistence.entity.Restaurante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",  uses = {RestaurantMapper.class,IngredienteMapper.class})
public interface MenuMapper {
    @Mappings({
            @Mapping(source = "id_menu",     target = "menuId"),
            @Mapping(source = "tipo_menu",   target = "type_menu"),
            @Mapping(source = "nombre_menu", target = "name_menu"),
            @Mapping(source = "precio",      target = "price"),
            @Mapping(source = "restaurante", target = "restaurant"),
            @Mapping(source = "ingredientes",target = "ingredients")
    })
    Menus toMenus(Menu menu);
    List<Menus> toMenuss(List<Menu> menuList);

    @InheritInverseConfiguration
    //@Mapping(target = "restaurante", ignore = true)
   //@Mapping(target = "ingredientes",ignore = true)
    Menu toMenu(Menus menus);
    List<Menu> toMenuS(List<Menus> menusLists);

}
