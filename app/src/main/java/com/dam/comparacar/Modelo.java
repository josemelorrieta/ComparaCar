package com.dam.comparacar;

import android.app.Application;

import java.util.ArrayList;

public class Modelo extends Application {
    public ArrayList<Coche> listadoCoches;
    public ArrayList<Coche> cochesSeleccionados;

    public Modelo() {
        this.listadoCoches = new ArrayList<Coche>();
        this.cochesSeleccionados = new ArrayList<Coche>();
    }
}
