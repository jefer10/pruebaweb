package com.quileia.pruebaweb.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="restaurante")
public class Restaurante {

    //propiedades de la entidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_restaurante")
    private Integer id_restaurante;

    @Column(name="razon_social")
    private String razon_social;

    @Column(name="nombre_comercial")
    private String nombre_comercial;

    @Column(name="tipo_de_restaurante")
    private Integer tipo_de_restaurante;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name= "hora_apertura")
    private String hora_apertura;

    @Column(name = "hora_cierre")
    private String hora_cierre;

    //relaciones entre entidades
    @OneToMany(mappedBy = "restaurante")//propiedad de la clase menu
    private List<Menu> menus;

//getter y setter
    public Integer getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public Integer getTipo_de_restaurante() {
        return tipo_de_restaurante;
    }

    public void setTipo_de_restaurante(Integer tipo_de_restaurante) {
        this.tipo_de_restaurante = tipo_de_restaurante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHora_apertura() {
        return hora_apertura;
    }

    public void setHora_apertura(String hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    public String getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(String hora_cierre) {
        this.hora_cierre = hora_cierre;
    }
}
