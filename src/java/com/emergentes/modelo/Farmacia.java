package com.emergentes.modelo;

public class Farmacia {
    private int id;
    private String nombre;
    private float peso;
    private float talla;
    private String vacuna;

    public Farmacia() {
        id = 0;
        nombre = "";
        peso = 0;
        talla = 0;
        vacuna ="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public float getpeso() {
        return peso;
    }

    public void setpeso(float peso) {
        this.peso = peso;
    }
    public float gettalla() {
        return talla;
    }

    public void settalla(float talla) {
        this.talla = talla;
    }

    public String getvacuna() {
        return vacuna;
    }

    public void setvacuna(String vacuna) {
        this.vacuna = vacuna;
    }
    
    
}
