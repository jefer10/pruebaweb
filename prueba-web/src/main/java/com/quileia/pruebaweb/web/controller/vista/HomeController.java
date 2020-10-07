package com.quileia.pruebaweb.web.controller.vista;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuario")
public class HomeController {

    @GetMapping(value = "/home")
    public ModelAndView home(){
        ModelAndView hom=new ModelAndView();
        hom.setViewName("home");
        return hom;
    }

    @GetMapping(value = "/restaurant-list")
    public ModelAndView restaurantList(){
        ModelAndView restaurantLis = new ModelAndView();
        restaurantLis.setViewName("restaurantList");
        return restaurantLis;
    }

    @GetMapping(value = "/crearRestaurante")
    public ModelAndView newRestaurant(){
        ModelAndView restaurant = new ModelAndView();
        restaurant.setViewName("newrestaurant");
        return restaurant;
    }

    @GetMapping(value = "/actualizarRestaurante")
    public ModelAndView actualizar(){
        ModelAndView update=new ModelAndView();
        update.setViewName("update");
        return update;
    }

    @GetMapping(value = "/Menu-list")
    public ModelAndView menulist(){
        ModelAndView menulist = new ModelAndView();
        menulist.setViewName("menulist");
        return menulist;
    }

    @GetMapping(value ="/menuRestaurante")
    public ModelAndView menuRestaurant(){
        ModelAndView menuRestaurante=new ModelAndView();
        menuRestaurante.setViewName("menuRestaurant");
        return menuRestaurante;
    }


}
