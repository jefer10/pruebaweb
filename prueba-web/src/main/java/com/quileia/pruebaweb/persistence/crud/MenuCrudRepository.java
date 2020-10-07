package com.quileia.pruebaweb.persistence.crud;

import com.quileia.pruebaweb.persistence.entity.Menu;
import com.quileia.pruebaweb.persistence.entity.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuCrudRepository extends CrudRepository<Menu,Integer> {

    @Query(value="SELECT * FROM menu WHERE tipo_menu = :tipo_menu",nativeQuery = true)
    List<Menu> findByTipo_menu(int tipo_menu);//como se busca usando sql

    @Query(value = "SELECT * FROM menu  WHERE tipo_menu = :tipo AND id_restaurante = :idres",nativeQuery = true)
    List<Menu> findByTipo_menuAndId_restaurante( int tipo,  int idres);


}
