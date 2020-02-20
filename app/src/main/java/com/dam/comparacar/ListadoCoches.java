package com.dam.comparacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoCoches extends AppCompatActivity {
    Modelo modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_coches);

        modelo = (Modelo) getApplication();

    }

//    private class CochesAdapter extends RecyclerView.Adapter<CochesAdapter.ViewHolder> {
//
//        private ArrayList<Coche> coches;
//
//        public Adaptador_RecyclerView(ArrayList<Coche> coches) {
//            this.coches = coches;
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//            // Your holder should contain a member variable
//            // for any view that will be set as you render a row
//            public ImageView imgCoche;
//            public TextView txtModelo, txtMotor, txtCombustible, txtPrecio;
//
//            // We also create a constructor that accepts the entire item row
//            // and does the view lookups to find each subview
//            public ViewHolder (View itemView) {
//                // Stores the itemView in a public final member variable that can be used
//                // to access the context from any ViewHolder instance.
//                super(itemView);
//
//                imgCoche = itemView.findViewById(R.id.imgCoche);
//                txtModelo = itemView.findViewById(R.id.txtModelo);
//                txtMotor = itemView.findViewById(R.id.txtMotor);
//                txtCombustible = itemView.findViewById(R.id.txtCombustible);
//                txtPrecio = itemView.findViewById(R.id.txtPrecio);
//
//            }
//        }
//    }
}
