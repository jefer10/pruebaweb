package com.quileia.pruebaweb.persistence;

import com.quileia.pruebaweb.domain.Restaurant;
import com.quileia.pruebaweb.domain.repository.RestaurantRepository;
import com.quileia.pruebaweb.persistence.crud.RestauranteCrudRepository;
import com.quileia.pruebaweb.persistence.entity.Restaurante;
import com.quileia.pruebaweb.persistence.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestauranteRepository implements RestaurantRepository {

    @Autowired //para que se intancie automaticamente
    private RestauranteCrudRepository restauranteCrudRepository;
    @Autowired //
    private RestaurantMapper mapper;


/*
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
*/

    @Override
    public List<Restaurant> getAll() {
        List<Restaurante> restaurantes =(List<Restaurante>) restauranteCrudRepository.findAll();
        List<Restaurant> restaurant= mapper.toRestaurants(restaurantes);
        return restaurant;
    }

    @Override
    public List<Restaurant> getByType(int type) {
        List<Restaurante>restaurantes=restauranteCrudRepository.findByTipo_de_restaurante(type);
        List<Restaurant>restaurants=mapper.toRestaurants(restaurantes);
        return restaurants;
    }

    @Override
    public Optional<Restaurant> getByID(int Id) {
        Optional<Restaurante> restaurante=restauranteCrudRepository.findById(Id);
        return restaurante.map(rest->mapper.toRestaurant(rest));
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Restaurante restaurante=mapper.toRestaurante(restaurant);
        restaurante=restauranteCrudRepository.save(restaurante);
        return mapper.toRestaurant(restaurante);
    }

    @Override
    public void deleteByID(int id) {
        restauranteCrudRepository.deleteById(id);
    }

    @Override
    public void updateByID(Restaurant restaurant) {
        Restaurante restaurante =mapper.toRestaurante(restaurant);
        restauranteCrudRepository.save(restaurante);
    }
}
