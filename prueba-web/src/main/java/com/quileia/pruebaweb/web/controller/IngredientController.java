package com.quileia.pruebaweb.web.controller;

import com.quileia.pruebaweb.domain.Ingredient;

import com.quileia.pruebaweb.domain.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//controlador de una api rest
@RequestMapping("/ingredient")
public class IngredientController {


    @Autowired
    IngredientService ingredientService;


    @GetMapping("/all")
    public ResponseEntity<List<Ingredient>> getAll(){
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getRestaurant(@PathVariable("id") int id){
        return ingredientService.getByID(id)
                .map(ingredient -> new ResponseEntity<>(ingredient,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Ingredient>  save(@RequestBody Ingredient ingredient){
        return  new ResponseEntity<>(ingredientService.create(ingredient),HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity  updateByID(@RequestBody Ingredient ingredient){
        if(ingredientService.updateByID(ingredient)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if (ingredientService.deleteByID(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


}
