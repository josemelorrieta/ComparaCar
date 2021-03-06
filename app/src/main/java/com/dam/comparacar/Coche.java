package com.dam.comparacar;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Coche {

    private int id;
    private String modelo;
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
    private String url;
    private String video;
    private String imagen;
    private String concesionario1;
    private float lat1;
    private float long1;
    private String concesionario2;
    private float lat2;
    private float long2;

    public Coche(){ }

    public Coche(int id, String modelo,int precio, int puertas, int plazas, int potencia, float consumo, int maletero, int cilindrada, String tipoCombustible, float aceleracion, int velocidadMax, String url, String imagen, String video, String concesionario1, float lat1, float long1, String concesionario2, float lat2, float long2) {
        this.id = id;
        this.modelo = modelo;
        this.precio = precio;
        this.puertas = puertas;
        this.plazas = plazas;
        this.potencia = potencia;
        this.consumo = consumo;
        this.maletero = maletero;
        this.cilindrada = cilindrada;
        this.tipoCombustible = tipoCombustible;
        this.aceleracion = aceleracion;
        this.velocidadMax = velocidadMax;
        this.url = url;
        this.imagen = imagen;
        this.video = video;
        this.concesionario1 = concesionario1;
        this.lat1 = lat1;
        this.lat2 = lat2;
        this.concesionario2 = concesionario2;
        this.long1 = long1;
        this.long2 = long2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipocombustible) {
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

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getConcesionario1 () {
        return this.concesionario1;
    }

    public void setConcesionario1(String concesionario1) {
        this.concesionario1 = concesionario1;
    }

    public float getLat1() {
        return lat1;
    }

    public void setLat1(float lat1) {
        this.lat1 = lat1;
    }

    public float getLong1() {
        return long1;
    }

    public void setLong1(float long1) {
        this.long1 = long1;
    }

    public String getConcesionario2 () {
        return this.concesionario2;
    }

    public void setConcesionario2(String concesionario2) {
        this.concesionario1 = concesionario2;
    }

    public float getLat2() {
        return lat2;
    }

    public void setLat2(float lat2) {
        this.lat2 = lat2;
    }

    public float getLong2() {
        return long2;
    }

    public void setLong2(float long2) {
        this.long2 = long2;
    }

}
