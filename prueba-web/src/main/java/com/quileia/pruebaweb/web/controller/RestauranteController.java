package com.quileia.pruebaweb.web.controller;

import com.quileia.pruebaweb.domain.Restaurant;
import com.quileia.pruebaweb.domain.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Restaurant>>getAll(){
        return new ResponseEntity<>(restaurantService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") int id){
        return restaurantService.getByID(id)
                .map(restaurant -> new ResponseEntity<>(restaurant,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Restaurant>  save(@RequestBody Restaurant restaurant){
        return  new ResponseEntity<>(restaurantService.create(restaurant),HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity  updateByID(@RequestBody Restaurant restaurant){
        if(restaurantService.updateByID(restaurant)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if (restaurantService.deleteByID(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
