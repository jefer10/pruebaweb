package com.quileia.pruebaweb.domain.service;

import com.quileia.pruebaweb.domain.Ingredient;
import com.quileia.pruebaweb.domain.Menus;
import com.quileia.pruebaweb.domain.repository.MenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
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

    public Optional<Menus> getByID(int id){
        Optional<Menus> menus=menusRepository.getByID(id);
        menus.map(res->{
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
        return null;
    }


    public void deleteByID(int id){
        menusRepository.deleteByID(id);
    }

    public Menus create(Menus menus) {
        List<Ingredient> ingredient = menus.getIngredients();
        int tamaño = ingredient.size();
        int calorias = 0;
        if (tamaño > 0) {
            for (Ingredient ingrediente : ingredient) {
                calorias = calorias + ingrediente.getCalories();
                System.out.println("xxxxxxxxxx" + calorias);
                if (calorias > 2000) {
                    return null;
                }
            }
        }
        return menusRepository.create(menus);
    }


    public Boolean updateByID(Menus menus){
        List<Ingredient> ingredient = menus.getIngredients();
        int tamaño = ingredient.size();
        int calorias = 0;
        if (tamaño > 0) {
            for (Ingredient ingrediente : ingredient) {
                calorias = calorias + ingrediente.getCalories();
                System.out.println("xxxxxxxxxx" + calorias);
                if (calorias > 2000) {
                    return false;
                }
            }
        }
        menusRepository.updateByID(menus);
        return true;
    }




}