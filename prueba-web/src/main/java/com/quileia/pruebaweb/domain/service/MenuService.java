package com.quileia.pruebaweb.domain.service;

import com.quileia.pruebaweb.domain.Ingredient;
import com.quileia.pruebaweb.domain.Menus;
import com.quileia.pruebaweb.domain.repository.MenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    MenusRepository menusRepository;


    public List<Menus> getAll(){
        return menusRepository.getAll();
    }

    public List<Menus> getByType(int id){
        return menusRepository.getByType(id);
    }

    public Optional<Menus> getByID(int id) {
        Optional<Menus> menus = menusRepository.getByID(id);
        return menus;
    }

    /*
    public Optional<Menus> getByID(int id){
        Optional<Menus> menus=menusRepository.getByID(id);
        return menus.map(res->{
                List<Ingredient> ingredient= res.getIngredients();
                int tamaño=ingredient.size();
                int calorias=0;
                if (tamaño>0){
                    for (Ingredient ingrediente:ingredient ) {
                        calorias=calorias+ingrediente.getCalories();
                        System.out.println("xxxxxxxxxx"+calorias);
                        if (calorias>2000){
                           deleteByID(id);
                            return null;
                        }else {
                            return res;
                        }
                    }
                }
                return null;
                });
    }
*/

    public Boolean deleteByID(int id){
        if (getByID(id).isPresent()){
            menusRepository.deleteByID(id);
            return true;
        }else {
            return false;
        }
    }

    public Menus create(Menus menus) {
        List<Ingredient> ingredient = menus.getIngredients();
        return menusRepository.create(menus);
    }


    public Boolean updateByID(Menus menus){
        menusRepository.updateByID(menus);
        return true;
    }


    public List<Menus> findByTipomenuAndIdrestaurante(int type, int Idresta){
        return menusRepository.findByTipo_menuAndId_restaurante(type,Idresta);
    }

}
