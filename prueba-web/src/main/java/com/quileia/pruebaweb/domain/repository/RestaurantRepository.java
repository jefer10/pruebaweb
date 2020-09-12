package com.quileia.pruebaweb.domain.repository;

import com.quileia.pruebaweb.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {

    public List<Restaurant> getAll();
    public  List<Restaurant> getByType(int type);
    public Optional<Restaurant> getByID(int Id);
    public Restaurant create(Restaurant restaurant);
    public void deleteByID(int id);
    public void updateByID(int id);
}
