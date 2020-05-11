package com.dam.comparacar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ActividadBase extends AppCompatActivity {
    public Modelo modelo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        modelo = (Modelo) getApplication();

        // Añadir botón de atras en la ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.acercaDe:
                Intent i = new Intent(this, AcercaDe.class);
                startActivity(i);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.alerta)
                .setTitle(R.string.exitTitle)
                .setMessage(R.string.exitMessage)
                .setPositiveButton(R.string.dialog_confirm, new DialogInterface.OnClickListener() {
                    DialogInterface.OnClickListener context = this;
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        salirAplicacion();
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, null)
                .show();
    }

    public void salirAplicacion() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ActivityCompat.finishAffinity(this);
        startActivity(homeIntent);
    }
}
