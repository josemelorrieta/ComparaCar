package com.dam.comparacar;

import androidx.appcompat.app.AppCompatActivity;

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
//        View decorView = getWindow().getDecorView();
//        if (Build.VERSION.SDK_INT < 16) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        } else {
//            // Hide the status bar.
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//
//        }
        setContentView(R.layout.activity_main);
// Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();



        modelo = (Modelo) getApplication();

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

        ContentValues registro = new ContentValues();
        registro.put("id", 1);
        registro.put("precio", 18000);
        registro.put("puertas", 4);
        registro.put("plazas", 5);
        registro.put("potencia", 100);
        registro.put("consumo", 6.7);
        registro.put("maletero", 320);
        registro.put("cilindrada", 4);
        registro.put("tipoCombustible", "gasolina");
        registro.put("aceleracion", 9.5);
        registro.put("velocidadMax", 220);
        int res = (int)db.insert("coches", null, registro);
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
            coche.setPrecio(fila.getInt(1));
            coche.setPuertas(fila.getInt(2));
            coche.setPlazas(fila.getInt(3));
            coche.setPotencia(fila.getInt(4));
            coche.setConsumo(fila.getFloat(5));
            coche.setMaletero(fila.getInt(6));
            coche.setCilindrada(fila.getInt(7));
            coche.setTipocombustible(fila.getString(8));
            coche.setAceleracion(fila.getFloat(9));
            coche.setVelocidadMax(fila.getInt(10));
            modelo.listadoCoches.add(coche);
        }

        db.close();
    }
}
