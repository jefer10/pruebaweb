package com.quileia.pruebaweb.domain.repository;

import com.quileia.pruebaweb.domain.Menus;
import com.quileia.pruebaweb.persistence.crud.MenuCrudRepository;
import com.quileia.pruebaweb.persistence.entity.Menu;
import com.quileia.pruebaweb.persistence.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MunusRepository implements MenusRepository{

    @Autowired
    private MenuCrudRepository menuCrudRepository;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menus> getAll() {
        List<Menu>menuList=(List<Menu>) menuCrudRepository.findAll();
        List<Menus>menusList=menuMapper.toMenuss(menuList);
        return menusList;
    }

    @Override
    public List<Menus> getByType(int type) {
        List<Menu>menuList=(List<Menu>) menuCrudRepository.findByTipo_menu(type);
        List<Menus>menusList=menuMapper.toMenuss(menuList);
        return menusList;
    }

    @Override
    public Optional<Menus> getByID(int Id) {
        Optional<Menu> menu=menuCrudRepository.findById(Id);
        return menu.map(res->menuMapper.toMenus(res));
    }

    @Override
    public Menus create(Menus Menus) {
        Menu menu=menuMapper.toMenu(Menus);
        menu=menuCrudRepository.save(menu);
        Menus menus=menuMapper.toMenus(menu);
        return menus;
    }

    @Override
    public void deleteByID(int id) {
        menuCrudRepository.deleteById(id);
    }

    @Override
    public void updateByID(Menus menus) {
        Menu menu=menuMapper.toMenu(menus);
        menuCrudRepository.save(menu);
    }
}
