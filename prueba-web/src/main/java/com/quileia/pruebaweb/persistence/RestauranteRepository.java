package com.quileia.pruebaweb.persistence;

import com.quileia.pruebaweb.persistence.crud.RestauranteCrudRepository;
import com.quileia.pruebaweb.persistence.entity.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestauranteRepository {

    private RestauranteCrudRepository restauranteCrudRepository;

    public List<Restaurante> getAllRestaurante(){
        return (List<Restaurante>) restauranteCrudRepository.findAll();
    }

    public List<Restaurante> getByTipo(int tipo_restaurante){
        return restauranteCrudRepository.findByTipo_de_restaurante(tipo_restaurante);
    }

    public Optional<Restaurante> getRestaurante(int id_restaurante){
        return restauranteCrudRepository.findById(id_restaurante);
    }
    public Restaurante createRestaurante(Restaurante restaurante){
        return restauranteCrudRepository.save(restaurante);
    }
    public void deleteRestaurante(int id_restaurante){

        restauranteCrudRepository.deleteById(id_restaurante);
    }

    public Restaurante updateRestaurante(int id_restaurante){
        //Optional<Restaurante> t=restauranteCrudRepository.findById(id_restaurante);
        Restaurante t=restauranteCrudRepository.findById_restaurante(id_restaurante);
        if (t instanceof Restaurante){
            return restauranteCrudRepository.save(t);
        }
        return null;
    }


}
