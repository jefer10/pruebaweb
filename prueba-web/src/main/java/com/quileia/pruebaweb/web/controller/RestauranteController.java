package com.quileia.pruebaweb.web.controller;

import com.quileia.pruebaweb.domain.Restaurant;
import com.quileia.pruebaweb.domain.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController//controlador de una api rest
@RequestMapping("/restaurant")
public class RestauranteController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<Restaurant> getAll(){
        return restaurantService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurant(@PathVariable("id") int id){
        return restaurantService.getByID(id);
    }

    @PostMapping("/save")
    public Restaurant save(@RequestBody Restaurant restaurant){
        return restaurantService.create(restaurant);
    }

    @PostMapping("/update")
    public Boolean updateByID(@RequestBody Restaurant restaurant){
        return restaurantService.updateByID(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id){
        return restaurantService.deleteByID(id);
    }
}
