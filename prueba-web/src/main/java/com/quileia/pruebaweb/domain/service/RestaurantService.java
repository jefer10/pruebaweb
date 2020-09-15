package com.quileia.pruebaweb.domain.service;

import com.quileia.pruebaweb.domain.Restaurant;
import com.quileia.pruebaweb.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public List<Restaurant> getAll(){
        return restaurantRepository.getAll();
    }

    public Optional<Restaurant> getByID(int Id){
        return restaurantRepository.getByID(Id);
    }

    public  List<Restaurant> getByType(int type){
        return  restaurantRepository.getByType(type);
    }

    public Restaurant create(Restaurant restaurant){
        return  restaurantRepository.create(restaurant);
    }
    public boolean deleteByID(int id){
        if (getByID(id).isPresent()){
            restaurantRepository.deleteByID(id);
            return true;
        }else {
            return false;
        }
    }

    public Boolean updateByID(Restaurant restaurant){
        restaurantRepository.updateByID(restaurant);
        Optional<Restaurant>restaurant1=getByID(restaurant.getRestaurantId());
        return restaurant1.map(rest -> {
            if (rest.toString().equals(restaurant.toString())){
                return true;
            }else {
                return false;
            }
        }).orElse(false);
    }


}
