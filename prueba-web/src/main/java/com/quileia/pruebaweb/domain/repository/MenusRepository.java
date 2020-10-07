package com.quileia.pruebaweb.domain.repository;

import com.quileia.pruebaweb.domain.Menus;


import java.util.List;
import java.util.Optional;

public interface MenusRepository {

    public List<Menus> getAll();
    public  List<Menus> getByType(int type);
    public Optional<Menus> getByID(int Id);
    public Menus create(Menus Menus);
    public void deleteByID(int id);
    public void updateByID(Menus menus);
    public List<Menus>findByTipo_menuAndId_restaurante(int type,int IDrest);

}
