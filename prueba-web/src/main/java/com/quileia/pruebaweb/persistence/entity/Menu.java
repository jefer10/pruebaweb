package com.quileia.pruebaweb.persistence.entity;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="menu")
public class Menu {

    //propiedades de la entidad
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer id_menu;

    @Column(name = "tipo_menu")
    private Integer tipo_menu;

    @Column(name = "nombre_menu")
    private  String nombre_menu;

    @Column(name = "precio")
    private  Double precio;

    @Column(name = "id_restaurante")
    private Integer restauranteID;

    //Relaciones entre entidades

    @JoinColumn(name = "id_restaurante", insertable=false,updatable = false)//el nombre de la llave foranea en la tabla
    @ManyToOne(optional = true)//para que exista menu sin restaurante
    private Restaurante restaurante;


    @JoinTable(name = "ingrediente_menu",//tabla de llaves
            joinColumns = @JoinColumn(name="id_menu",insertable = false,updatable = false),// FK para tabla padre
            inverseJoinColumns = @JoinColumn(name="id_ingrediente",insertable = false,updatable = false))//FK para tabla hijo
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Ingrediente> ingredientes;


    ///getter y setter

    public Integer getRestauranteID() {
        return restauranteID;
    }

    public void setRestauranteID(Integer restauranteID) {
        this.restauranteID = restauranteID;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Integer getId_menu() {
        return id_menu;
    }

    public void setId_menu(Integer id_menu) {
        this.id_menu = id_menu;
    }

    public Integer getTipo_menu() {
        return tipo_menu;
    }

    public void setTipo_menu(Integer tipo_menu) {
        this.tipo_menu = tipo_menu;
    }

    public String getNombre_menu() {
        return nombre_menu;
    }

    public void setNombre_menu(String nombre_menu) {
        this.nombre_menu = nombre_menu;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }



}
