package com.dam.comparacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ListadoCoches extends AppCompatActivity {
    Modelo modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_coches);

        modelo = (Modelo) getApplication();

        RecyclerView listaCoches = findViewById(R.id.rvListadoCoches);

        listaCoches.setAdapter(new CochesAdapter(modelo.listadoCoches));
        listaCoches.setLayoutManager(new LinearLayoutManager(this));
        listaCoches.setHasFixedSize(true);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        listaCoches.addItemDecoration(itemDecoration);

    }

    private class CochesAdapter extends RecyclerView.Adapter<CochesAdapter.ViewHolder> {

        private ArrayList<Coche> coches;

        public CochesAdapter(ArrayList<Coche> coches) {
            this.coches = coches;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // Your holder should contain a member variable
            // for any view that will be set as you render a row
            public ImageView imgCoche;
            public TextView txtModelo, txtMotor, txtCombustible, txtPrecio;
            private Context context;

            // We also create a constructor that accepts the entire item row
            // and does the view lookups to find each subview
            public ViewHolder (Context context, View itemView) {
                // Stores the itemView in a public final member variable that can be used
                // to access the context from any ViewHolder instance.
                super(itemView);

                imgCoche = itemView.findViewById(R.id.imgCoche);
                txtModelo = itemView.findViewById(R.id.txtModelo);
                txtMotor = itemView.findViewById(R.id.txtMotor);
                txtCombustible = itemView.findViewById(R.id.txtCombustible);
                txtPrecio = itemView.findViewById(R.id.txtPrecio);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    /*Intent intent = new Intent(context.getApplicationContext(), CocheDetalle.class);
                    intent.putExtra("position", position);
                    startActivity(intent);*/
                }
                onClickItem(position);
            }
        }

        @Override
        public int getItemViewType(int position) {
            return R.layout.item_list_coche;
        }

        @Override
        public CochesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();

            LayoutInflater inflater = LayoutInflater.from(context);
            View itemCoche = inflater.inflate(viewType, parent, false);

            CochesAdapter.ViewHolder vh  = new CochesAdapter.ViewHolder(context, itemCoche);
            return vh;
        }

        @Override
        public void onBindViewHolder(CochesAdapter.ViewHolder holder, int position) {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
            //Si no hay resultados
            /*if (alojamientos.size() == 0) {
                lyEmpty.setVisibility(View.VISIBLE);
                lyLista.setVisibility(View.GONE);
            } else {
                lyEmpty.setVisibility(View.GONE);
                lyLista.setVisibility(View.VISIBLE);
            }*/
            // - get element from your dataset at this position
            // - replace the contents of the view with that element

            Coche coche = coches.get(position);
            int idImagen = getResources().getIdentifier(coche.getImagen() , "drawable", getPackageName());
            holder.imgCoche.setImageResource(idImagen);
            holder.txtModelo.setText(coche.getModelo());
            holder.txtMotor.setText(coche.getCilindrada() + "cc. / " + coche.getPotencia() + "CV.");
            holder.txtCombustible.setText(coche.getTipoCombustible());
            holder.txtPrecio.setText("Desde " + nf.format(coche.getPrecio()) + "€");
        }

        @Override
        public int getItemCount() {
            /*if (coches.size() == 0) {
                lyEmpty.setVisibility(View.VISIBLE);
                lyLista.setVisibility(View.GONE);
            } else {
                lyEmpty.setVisibility(View.GONE);
                lyLista.setVisibility(View.VISIBLE);
            }*/
            return coches.size();
        }

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

    public void seleccionarCoche(View view) {
        Toast.makeText(this, "Seleccionado", Toast.LENGTH_SHORT).show();
    }

    private void onClickItem(int position) {
        Toast.makeText(this, "Click en " + position, Toast.LENGTH_SHORT).show();
    }
}
