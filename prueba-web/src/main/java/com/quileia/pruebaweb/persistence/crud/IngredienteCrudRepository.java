package com.quileia.pruebaweb.persistence.crud;

import com.quileia.pruebaweb.persistence.entity.Ingrediente;
import com.quileia.pruebaweb.persistence.entity.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredienteCrudRepository extends CrudRepository<Ingrediente,Integer> {

    @Query(value="SELECT * FROM ingrediente WHERE calorias = :caloria",nativeQuery = true)
    List<Ingrediente> findByCaloria(int calorias);//como se busca usando sql

    @Query(value = "SELECT ingredientes, menu FROM menu, ingrediente_menu, ingrediente WHERE " +
            "ingrediente.id_ingrediente = ingrediente_menu.id_ingrediente AND ingrediente_menu.id_menu = menu.id_menu" +
            "AND menu.id_menu = :ID",nativeQuery = true)
    List<Ingrediente>findByIngredientJoinMenu(int ID);
}
