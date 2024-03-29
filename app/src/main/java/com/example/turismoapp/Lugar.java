package com.example.turismoapp;

import java.io.Serializable;

public class Lugar implements Serializable {

    private int id;
    private String nombre;
    private String direccion;
    private int tarifa;
    private double coordenadax;
    private double coordenaday;
    private int calificacion;
    private String descripcion;
    private String imagen;

    public Lugar() {
    }

    public Lugar(int id, String nombre, String direccion, int tarifa, double coordenadax, double coordenaday, int calificacion, String descripcion, String ruta) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarifa = tarifa;
        this.coordenadax = coordenadax;
        this.coordenaday = coordenaday;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.imagen = ruta;
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

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
