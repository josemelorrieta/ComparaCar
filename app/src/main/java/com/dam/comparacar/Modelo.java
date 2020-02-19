package com.dam.comparacar;

import android.app.Application;

import java.util.ArrayList;

public class Modelo extends Application {
    public ArrayList<String> listadoCoches;

    public Modelo() {
        this.listadoCoches = new ArrayList<String>();
    }
}
