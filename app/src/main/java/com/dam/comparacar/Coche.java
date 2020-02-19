package com.dam.comparacar;

public class Coche {

    private int id;
    private int precio;
    private int puertas;
    private int plazas;
    private int potencia;
    private float consumo;
    private int maletero;
    private int cilindrada;
    private String tipoCombustible;
    private float aceleracion;
    private int velocidadMax;

    public Coche(){ }
    public Coche(int id,int precio, int puertas, int plazas, int potencia, float consumo, int maletero, int cilindarada, String tipocombustible, float aceleracion, int velociedadMax) {
        this.id = id;
        this.precio = precio;
        this.puertas = puertas;
        this.plazas = plazas;
        this.potencia = potencia;
        this.consumo = consumo;
        this.maletero = maletero;
        this.cilindrada = cilindarada;
        this.tipoCombustible = tipocombustible;
        this.aceleracion = aceleracion;
        this.velocidadMax = velocidadMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public int getMaletero() {
        return maletero;
    }

    public void setMaletero(int maletero) {
        this.maletero = maletero;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindarada) {
        this.cilindrada = cilindarada;
    }

    public String getTipocombustible() {
        return tipoCombustible;
    }

    public void setTipocombustible(String tipocombustible) {
        this.tipoCombustible = tipocombustible;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(float aceleracion) {
        this.aceleracion = aceleracion;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velociedadMax) {
        this.velocidadMax = velocidadMax;
    }
}
