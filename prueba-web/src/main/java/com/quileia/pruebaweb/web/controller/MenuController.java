package com.quileia.pruebaweb.web.controller;

import com.quileia.pruebaweb.domain.Menus;

import com.quileia.pruebaweb.domain.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//controlador de una api rest
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/all")
    public ResponseEntity<List<Menus>> getAll(){
        return new ResponseEntity<>(menuService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menus> getByID(@PathVariable("id") int id){
        return menuService.getByID(id)
                .map(menu -> new ResponseEntity<>(menu,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Menus>  save(@RequestBody Menus menus){
        return  new ResponseEntity<>(menuService.create(menus),HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity  updateByID(@RequestBody Menus menus){
        if(menuService.updateByID(menus)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if (menuService.deleteByID(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    //@GetMapping("/find")
    //public ResponseEntity<List<Menus>> findTypeandIdRes(@RequestParam(name = "type",defaultValue = "1") int type, @RequestParam(name = "id",defaultValue = "1") int id){
    //    return new ResponseEntity<>(menuService.findByTipomenuAndIdrestaurante(type,id),HttpStatus.OK);
    //}

    @GetMapping("/buscar/{type}/{id}")
    public ResponseEntity<List<Menus>> find(@PathVariable("type") int type, @PathVariable("id") int id){
        return new ResponseEntity<>(menuService.findByTipomenuAndIdrestaurante(type,id),HttpStatus.OK);
    }
}
