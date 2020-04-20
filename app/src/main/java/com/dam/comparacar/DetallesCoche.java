package com.dam.comparacar;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class DetallesCoche extends AppCompatActivity {

    TextView modelo,aceleracion,velociedadMax,cilindrada,consumo,maletero,plazas,potencia,puertas,precio,tipocombustible,url;
    Modelo mod;
    VideoView vV;
    MediaController ctlr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_coche);
        mod = (Modelo) getApplication();

        Bundle bundle = getIntent().getExtras();
        int dato = bundle.getInt("position");

        modelo=(TextView)findViewById(R.id.textView19);
        precio=(TextView)findViewById(R.id.textView20);
        velociedadMax=(TextView)findViewById(R.id.textView21);
        aceleracion=(TextView)findViewById(R.id.textView22);
        cilindrada=(TextView)findViewById(R.id.textView23);
        consumo=(TextView)findViewById(R.id.textView24);
        potencia=(TextView)findViewById(R.id.textView25);
        tipocombustible=(TextView)findViewById(R.id.textView26);
        plazas=(TextView)findViewById(R.id.textView27);
        maletero=(TextView)findViewById(R.id.textView28);
        puertas=(TextView)findViewById(R.id.textView31);

       // url=(TextView)findViewById(R.id.textView30);



        modelo.setText(mod.listadoCoches.get(dato).getModelo());
        precio.setText(String.valueOf(mod.listadoCoches.get(dato).getPrecio()));
        velociedadMax.setText(String.valueOf(mod.listadoCoches.get(dato).getVelocidadMax()));
        aceleracion.setText(String.valueOf(mod.listadoCoches.get(dato).getAceleracion()));
        cilindrada.setText(String.valueOf(mod.listadoCoches.get(dato).getCilindrada()));
        consumo.setText(String.valueOf(mod.listadoCoches.get(dato).getConsumo()));
        potencia.setText( String.valueOf(mod.listadoCoches.get(dato).getPotencia()));
        tipocombustible.setText( mod.listadoCoches.get(dato).getTipoCombustible());
        plazas.setText(String.valueOf(mod.listadoCoches.get(dato).getPlazas()));
        maletero.setText(String.valueOf( mod.listadoCoches.get(dato).getMaletero()));
        puertas.setText( String.valueOf(mod.listadoCoches.get(dato).getPuertas()));


      //  url.setText( mod.listadoCoches.get(dato).getUrl());

        //modelo.setText( mod.listadoCoches.get(dato).getVideo());


       /* vV=(VideoView)findViewById(R.id.videoView);

       Uri uri =Uri.parse("https://www.youtube.com/watch?v=hyP6c8T6d3Y");

        vV.setMediaController(new MediaController(this));
        vV.setVideoURI(uri);
        vV.requestFocus();
        vV.start();*/
    }


}
