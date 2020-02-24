package com.dam.comparacar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class ComparacionCoches extends ActividadBase {
    ImageView imgCoche1, imgCoche2;
    TextView txtModelo1, txtModelo2, txtCilindrada1, txtCilindrada2, txtPotencia1, txtPotencia2;
    TextView txtCombustible1, txtCombustible2, txtConsumo1, txtConsumo2, txtAceleracion1, txtAceleracion2;
    TextView txtVelocidadMax1, txtVelocidadMax2, txtPlazas1, txtPlazas2, txtPuertas1, txtPuertas2;
    TextView txtMaletero1, txtMaletero2, txtPrecio1, txtPrecio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacion_coches);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);

        imgCoche1 = findViewById(R.id.imgCoche1);
        imgCoche2 = findViewById(R.id.imgCoche2);
        txtModelo1 = findViewById(R.id.txtModelo1);
        txtModelo2 = findViewById(R.id.txtModelo2);
        txtCilindrada1 = findViewById(R.id.txtCilindrada1);
        txtCilindrada2 = findViewById(R.id.txtCilindrada2);
        txtPotencia1 = findViewById(R.id.txtPotencia1);
        txtPotencia2 = findViewById(R.id.txtPotencia2);
        txtCombustible1 = findViewById(R.id.txtCombustible1);
        txtCombustible2 = findViewById(R.id.txtCombustible2);
        txtConsumo1 = findViewById(R.id.txtConsumo1);
        txtConsumo2 = findViewById(R.id.txtConsumo2);
        txtAceleracion1 = findViewById(R.id.txtAceleracion1);
        txtAceleracion2 = findViewById(R.id.txtAceleracion2);
        txtVelocidadMax1 = findViewById(R.id.txtVelocidadMax1);
        txtVelocidadMax2 = findViewById(R.id.txtVelocidadMax2);
        txtPlazas1 = findViewById(R.id.txtPlazas1);
        txtPlazas2 = findViewById(R.id.txtPlazas2);
        txtPuertas1 = findViewById(R.id.txtPuertas1);
        txtPuertas2 = findViewById(R.id.txtPuertas2);
        txtMaletero1 = findViewById(R.id.txtMaletero1);
        txtMaletero2 = findViewById(R.id.txtMaletero2);
        txtPrecio1 = findViewById(R.id.txtPrecio1);
        txtPrecio2 = findViewById(R.id.txtPrecio2);

        Coche coche1 = modelo.cochesSeleccionados.get(0);
        Coche coche2 = modelo.cochesSeleccionados.get(1);

        imgCoche1.setImageResource(getResources().getIdentifier(coche1.getImagen() , "drawable", getPackageName()));
        imgCoche2.setImageResource(getResources().getIdentifier(coche2.getImagen() , "drawable", getPackageName()));
        txtModelo1.setText(coche1.getModelo());
        txtModelo2.setText(coche2.getModelo());
        txtCilindrada1.setText(coche1.getCilindrada() + " cc");
        txtCilindrada2.setText(coche2.getCilindrada() + " cc");
        txtPotencia1.setText(coche1.getPotencia() + " CV");
        txtPotencia2.setText(coche2.getPotencia() + " CV");
        txtCombustible1.setText(coche1.getTipoCombustible());
        txtCombustible2.setText(coche2.getTipoCombustible());
        txtConsumo1.setText(coche1.getConsumo() + " l/100 Km");
        txtConsumo2.setText(coche2.getConsumo() + " l/100 Km");
        txtAceleracion1.setText(coche1.getAceleracion() + " s");
        txtAceleracion2.setText(coche2.getAceleracion() + " s");
        txtVelocidadMax1.setText(coche1.getVelocidadMax() + " Km/h");
        txtVelocidadMax2.setText(coche2.getVelocidadMax() + " Km/h");
        txtPlazas1.setText(String.valueOf(coche1.getPlazas()));
        txtPlazas2.setText(String.valueOf(coche2.getPlazas()));
        txtPuertas1.setText(String.valueOf(coche1.getPuertas()));
        txtPuertas2.setText(String.valueOf(coche2.getPuertas()));
        txtMaletero1.setText(coche1.getMaletero() + " l");
        txtMaletero2.setText(coche2.getMaletero() + " l");
        txtPrecio1.setText("Desde " + nf.format(coche1.getPrecio()) + "€");
        txtPrecio2.setText("Desde " + nf.format(coche2.getPrecio()) + "€");
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
