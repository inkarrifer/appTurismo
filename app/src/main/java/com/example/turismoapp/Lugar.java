package com.example.turismoapp;

public class Lugar {

    private int id;
    private String nombre;
    private String dirección;

    public Lugar(int id, String nombre, String dirección) {
        this.id = id;
        this.nombre = nombre;
        this.dirección = dirección;
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

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}
