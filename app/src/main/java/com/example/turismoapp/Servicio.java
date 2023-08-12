package com.example.turismoapp;

import java.io.Serializable;

public class Servicio implements Serializable {
    private int id;
    private String nombre;
    private String direccion;
    private String tipo;
    private double coordenadax;
    private double coordenaday;
    private String imagen;

    public Servicio() {
    }

    public Servicio(int id, String nombre, String direccion, String tipo, double coordenadax, double coordenaday, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
        this.coordenadax = coordenadax;
        this.coordenaday = coordenaday;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCoordenadax() {
        return coordenadax;
    }

    public void setCoordenadax(double coordenadax) {
        this.coordenadax = coordenadax;
    }

    public double getCoordenaday() {
        return coordenaday;
    }

    public void setCoordenaday(double coordenaday) {
        this.coordenaday = coordenaday;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
