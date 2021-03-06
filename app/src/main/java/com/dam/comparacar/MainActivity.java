package com.dam.comparacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected Modelo modelo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelo = (Modelo) getApplication();
        modelo.cochesSeleccionados.clear();

        AdministradorBDSQLite adminBD = new AdministradorBDSQLite(this, "ComparaCar", null, 1);
        SQLiteDatabase db = adminBD.getWritableDatabase();

        int numFilas = (int)DatabaseUtils.queryNumEntries(db, "coches");
        if (numFilas == 0) {
            cargarDatosEnBD();
        } else {
            recuperarDatosDeBD();
        }

        db.close();

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                pasarAlistado();
            }
        }, 5000);
    }

    private void pasarAlistado() {
        Intent intent = new Intent(this, ListadoCoches.class);
        startActivity(intent);
    }

    private void cargarDatosEnBD() {
        AdministradorBDSQLite adminBD = new AdministradorBDSQLite(this, "ComparaCar", null, 1);
        SQLiteDatabase db = adminBD.getWritableDatabase();

        //url video imagen lat,long
        Coche AudiA1 = new Coche(1,"Audi A1",22400,5,5,115,5.8f,335,999,"gasolina",9.5f,203,"https://www.audi.es/es/web/es/modelos/a1/nuevo-a1-sportback.html#layer=/es/web/es/modelos/a1/nuevo-a1-sportback.engine_compare.gbaas4_2.techdata.html","audia1","https://www.youtube.com/watch?v=BQuQ46XM9RE", "Leioa Wagen" ,43.321309f, -2.981054f, "Alzaga Motor",43.264996f,-2.937301f);
        Coche RenaultClio = new Coche(2,"Renault Clio Intens",13441,5,5,100,5.3f,366,999,"gasolina",14.7f,187,"https://www.renault.es/turismos/clio/equipamientos.html?gradeCode=ENS_MDL2P1SERIELIM3","renaultclio","https://www.youtube.com/watch?v=3RNZemcJmrs", "Gaursa", 43.264094f,-2.940942f, "Leioa Berri", 43.321504f,-2.981126f);
        Coche OpelCorsa = new Coche(3,"Opel Corsa GS Line",18800,5,5,131,5.6f,309,1199,"gasolina",8.7f,208,"https://www.opel.es/coches/gama-corsa/corsa/resumen.html","opelcorsagsline","https://www.youtube.com/watch?v=1BnngtGtsxM", "Meuri", 43.295413f,-2.972185f, "Opel Goñi Motor", 43.318480f,-3.002606f);
        Coche VolkswagenGolf = new Coche(4,"Volkwagen Golf Life",32430,5,5,150,5.7f,381,1498,"gasolina",8.5f,224,"https://www.volkswagen.es/es/modelos-configurador/golf-8.html","volkswagengolflife","https://www.youtube.com/watch?v=aGBWZhobGkg", "Auvol", 43.262893f,-2.944803f, "Leioa Wagen",43.328378f,-2.992890f);
        Coche SeatLeon = new Coche(5,"Seat Leon",23240,5,5,110,4.6f,380,1598,"diesel",10.4f,194,"https://www.seat.es/coches/leon-5-puertas/modelo.html", "seatleon","https://www.youtube.com/watch?v=mJejGouKNZk", "Automóviles Galindo",43.304533f,-3.000340f, "Meuri", 43.295413f,-2.972185f);
        Coche AudiA3  = new Coche(6,"Audi A3",30740,5,5,116,5.4f,380,1598,"diesel",10.4f,205,"https://www.audi.es/es/web/es/modelos/a3/a3-sportback.html#layer=/es/web/es/modelos/a3/a3-sportback.engine_compare.8vfadc_1.techdata.html?pid=int:main_page-intro:a3sb_datostecnicos_20mar.html","audia3","https://www.youtube.com/watch?v=NxjHis4vB1U","Leioa Wagen" ,43.321309f, -2.981054f, "Alzaga Motor",43.264996f,-2.937301f);
        Coche AudiA4 = new Coche(7,"Audi A4",41140,5,5,136,5.4f,460,1968,"diesel",9.5f,210,"https://www.audi.es/es/web/es/modelos/a4/a4.html#layer=/es/web/es/modelos/a4/a4.engine_compare.8wcbyg_2_gyehyeh.techdata.html","audia4","https://www.youtube.com/watch?v=Bb76E7FbhDY","Leioa Wagen" ,43.321309f, -2.981054f, "Alzaga Motor",43.264996f,-2.937301f);
        Coche VolkswagenPassatGte = new Coche(8,"Volkswagen Passat GTE",44895,5,5,115,1.5f,402,1395,"Híbrido",7.4f,225,"https://www.volkswagen.es/es/modelos-configurador/golf-gte.html","volkswagenpassatgte","https://www.youtube.com/watch?v=MaR7kSTvAdE","Auvol", 43.262893f,-2.944803f, "Leioa Wagen",43.328378f,-2.992890f);
        Coche FordMondeo = new Coche(9,"Ford Mondeo Hybrid Sportbreak",36648,5,5,165,5.6f,550,1498,"Híbrido",10.3f,214,"https://www.ford.es/turismos/mondeo/modelos/trend","fordmondeo","https://www.youtube.com/watch?v=dgM-zikq3Rw", "Ford Mintegui",43.321906f,-2.973969f, "Gordoniz Motor",43.252799f,-2.945243f);
        /*AudiA1.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.audia1, null));
        RenaultClio.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.renaultclio, null));
        OpelCorsa.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.opelcorsagsline, null));
        VolkswagenGolf.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.volkswagengolflife, null));
        SeatLeon.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.seatleon, null));
        AudiA3.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.audia3, null));
        AudiA4.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.audia4, null));
        VolkswagenPassatGte.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.volkswagenpassatgte, null));
        FordMondeo.setImg(ResourcesCompat.getDrawable(getResources(), R.drawable.fordmondeo, null));*/

        modelo.listadoCoches.add(AudiA1);
        modelo.listadoCoches.add(RenaultClio);
        modelo.listadoCoches.add(OpelCorsa);
        modelo.listadoCoches.add(VolkswagenGolf);
        modelo.listadoCoches.add(SeatLeon);
        modelo.listadoCoches.add(AudiA3);
        modelo.listadoCoches.add(AudiA4);
        modelo.listadoCoches.add(VolkswagenPassatGte);
        modelo.listadoCoches.add(FordMondeo);

        for (int i=0;i<modelo.listadoCoches.size();i++) {
            ContentValues registro = new ContentValues();
            registro.put("id", i + 1);
            registro.put("modelo", modelo.listadoCoches.get(i).getModelo());
            registro.put("precio", modelo.listadoCoches.get(i).getPrecio());
            registro.put("puertas", modelo.listadoCoches.get(i).getPuertas());
            registro.put("plazas", modelo.listadoCoches.get(i).getPlazas());
            registro.put("potencia", modelo.listadoCoches.get(i).getPotencia());
            registro.put("consumo", modelo.listadoCoches.get(i).getConsumo());
            registro.put("maletero", modelo.listadoCoches.get(i).getMaletero());
            registro.put("cilindrada", modelo.listadoCoches.get(i).getCilindrada());
            registro.put("tipoCombustible", modelo.listadoCoches.get(i).getTipoCombustible());
            registro.put("aceleracion", modelo.listadoCoches.get(i).getAceleracion());
            registro.put("velocidadMax", modelo.listadoCoches.get(i).getVelocidadMax());
            registro.put("url", modelo.listadoCoches.get(i).getUrl());
            registro.put("imagen", modelo.listadoCoches.get(i).getImagen());
            registro.put("video", modelo.listadoCoches.get(i).getVideo());
            registro.put("concesionario1", modelo.listadoCoches.get(i).getConcesionario1());
            registro.put("lat1", modelo.listadoCoches.get(i).getLat1());
            registro.put("long1", modelo.listadoCoches.get(i).getLong1());
            registro.put("concesionario2", modelo.listadoCoches.get(i).getConcesionario2());
            registro.put("lat2", modelo.listadoCoches.get(i).getLat2());
            registro.put("long2", modelo.listadoCoches.get(i).getLong2());
            int res = (int) db.insert("coches", null, registro);
        }
        db.close();
    }

    private void recuperarDatosDeBD() {
        AdministradorBDSQLite adminBD = new AdministradorBDSQLite(this, "ComparaCar", null, 1);
        SQLiteDatabase db = adminBD.getWritableDatabase();

        modelo.listadoCoches.clear();
        Cursor fila = db.rawQuery("Select * from coches", null);

        while (fila.moveToNext()) {
            Coche coche = new Coche();
            coche.setId(fila.getInt(0));
            coche.setModelo(fila.getString(1));
            coche.setPrecio(fila.getInt(2));
            coche.setPuertas(fila.getInt(3));
            coche.setPlazas(fila.getInt(4));
            coche.setPotencia(fila.getInt(5));
            coche.setConsumo(fila.getFloat(6));
            coche.setMaletero(fila.getInt(7));
            coche.setCilindrada(fila.getInt(8));
            coche.setTipoCombustible(fila.getString(9));
            coche.setAceleracion(fila.getFloat(10));
            coche.setVelocidadMax(fila.getInt(11));
            coche.setUrl(fila.getString(12));
            coche.setImagen(fila.getString(13));
            coche.setVideo(fila.getString(14));
            coche.setConcesionario1(fila.getString(15));
            coche.setLat1(fila.getFloat(16));
            coche.setLong1(fila.getFloat(17));
            coche.setConcesionario2(fila.getString(18));
            coche.setLat2(fila.getFloat(19));
            coche.setLong2(fila.getFloat(20));
            /*int idImagen = getResources().getIdentifier(coche.getImagen() , "drawable", getPackageName());
            coche.setImg(getResources().getDrawable(idImagen));*/
            modelo.listadoCoches.add(coche);
        }

        db.close();
    }
}
