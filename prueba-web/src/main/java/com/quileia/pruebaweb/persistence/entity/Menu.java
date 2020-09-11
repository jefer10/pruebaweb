package com.quileia.pruebaweb.persistence.entity;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="menu")
public class Menu {

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

    @ManyToOne(optional = true)//para que exista menu sin restaurante
    @JoinColumn(name = "id_restaurante",insertable = false,updatable = false)//el nombre de la llave foranea en la tabla
    private Restaurante restaurante;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingrediente_menu",//tabla de llaves
            joinColumns = @JoinColumn(name="id_menu",insertable = false,updatable = false),// FK tabla padre
            inverseJoinColumns = @JoinColumn(name="id_ingrediente",insertable = false,updatable = false))//FK tabla hijo
    private List<Ingrediente> ingredientes;


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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
