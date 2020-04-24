package com.dam.comparacar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.text.NumberFormat;
import java.util.Locale;

public class DetallesCoche extends YouTubeBaseActivity {

    TextView modelo,aceleracion,velociedadMax,cilindrada,consumo,maletero,plazas,potencia,puertas,precio,tipocombustible,url;
    Modelo mod;
    YouTubePlayerView video;
    MediaController ctlr;
    int dato;
    String videoUrl, videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_coche);
        mod = (Modelo) getApplication();

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);

        Bundle bundle = getIntent().getExtras();
        dato = bundle.getInt("position");

        modelo=(TextView)findViewById(R.id.txtModeloItem);
        precio=(TextView)findViewById(R.id.txtPrecioItem);
        velociedadMax=(TextView)findViewById(R.id.txtVelMaxItem);
        aceleracion=(TextView)findViewById(R.id.txtAcelItem);
        cilindrada=(TextView)findViewById(R.id.txtCilindradaItem);
        consumo=(TextView)findViewById(R.id.txtConsumoItem);
        potencia=(TextView)findViewById(R.id.txtPotenciaItem);
        tipocombustible=(TextView)findViewById(R.id.txtCombustibleItem);
        plazas=(TextView)findViewById(R.id.txtPlazasItem);
        maletero=(TextView)findViewById(R.id.txtMaleteroItem);
        puertas=(TextView)findViewById(R.id.txtPuertasItem);
        video = (YouTubePlayerView) findViewById(R.id.videoView);

        videoUrl = mod.listadoCoches.get(dato).getVideo();
        videoId = videoUrl.substring(videoUrl.lastIndexOf("=") + 1);
        playVideo(videoId, video);

        modelo.setText(mod.listadoCoches.get(dato).getModelo());
        precio.setText(String.valueOf("Dedsde " + nf.format(mod.listadoCoches.get(dato).getPrecio()) + " €"));
        velociedadMax.setText(String.valueOf(mod.listadoCoches.get(dato).getVelocidadMax()) + " Km/h");
        aceleracion.setText(String.valueOf(mod.listadoCoches.get(dato).getAceleracion()) + " s");
        cilindrada.setText(String.valueOf(mod.listadoCoches.get(dato).getCilindrada()) + " cc");
        consumo.setText(String.valueOf(mod.listadoCoches.get(dato).getConsumo()) + " l/100 Km");
        potencia.setText( String.valueOf(mod.listadoCoches.get(dato).getPotencia()) + " CV");
        tipocombustible.setText( mod.listadoCoches.get(dato).getTipoCombustible());
        plazas.setText(String.valueOf(mod.listadoCoches.get(dato).getPlazas()));
        maletero.setText(String.valueOf( mod.listadoCoches.get(dato).getMaletero()) + " l");
        puertas.setText( String.valueOf(mod.listadoCoches.get(dato).getPuertas()));

    }

    public void playVideo(final String videoId, YouTubePlayerView youTubePlayerView) {
        //initialize youtube player view
        youTubePlayerView.initialize("@string/youtube_key",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.cueVideo(videoId);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }

    public void dondeComprar(View v) {
        Intent i = new Intent(this, DondeComprar.class);
        i.putExtra("posicion", dato);
        startActivity(i);
    }
}
