package com.quileia.pruebaweb.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @Column(name = "id_ingrediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ingrediente;

    @Column(name="nombre")
    private String nombre;

    @Column(name="calorias")
    private Integer calorias;

    @ManyToMany(mappedBy = "ingrediente")
    private List<Menu> menus;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
