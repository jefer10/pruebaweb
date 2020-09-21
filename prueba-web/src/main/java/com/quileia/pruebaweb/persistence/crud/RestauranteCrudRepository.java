package com.quileia.pruebaweb.persistence.crud;

import com.quileia.pruebaweb.persistence.entity.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestauranteCrudRepository extends CrudRepository<Restaurante,Integer> {

    @Query(value="SELECT * FROM restaurante WHERE tipo_de_restaurante = :tipo_de_restaurante",nativeQuery = true)
    List<Restaurante> findByTipo_de_restaurante(int tipo_de_restaurante);//como se busca usando sql

    //List<Restaurante> findBytipo_de_restaurante(int tipo_de_restaurante);//(query method) es lo mismo que el de arriba



    //Restaurante findById_restaurante(int id_restaurante);
}
