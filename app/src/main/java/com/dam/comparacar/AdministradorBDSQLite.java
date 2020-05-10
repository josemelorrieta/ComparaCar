package com.dam.comparacar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdministradorBDSQLite extends SQLiteOpenHelper {
    public AdministradorBDSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table coches(id int primary key,modelo text, precio int, puertas int, plazas int, potencia int, consumo real, maletero int, cilindrada int, tipoCombustible text, aceleracion real, velocidadMax int, url text, imagen text, video text, concesionario1 text, lat1 real, long1 real, concesionario2 text, lat2 real, long2 real)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
