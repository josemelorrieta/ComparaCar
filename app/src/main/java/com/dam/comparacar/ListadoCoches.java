package com.dam.comparacar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ListadoCoches extends AppCompatActivity {
    Modelo modelo;
    ConstraintLayout lySeleccion;
    FloatingActionButton fabComparar;
    TextView txtCoche1, txtCoche2;
    RecyclerView listaCoches;
    ConstraintLayout lyContListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_coches);

        modelo = (Modelo) getApplication();

        lySeleccion = findViewById(R.id.botonesSeleccion);
        fabComparar = findViewById(R.id.fabComparar);
        txtCoche1 = findViewById(R.id.txtSelec1);
        txtCoche2 = findViewById(R.id.txtSelec2);
        listaCoches = findViewById(R.id.rvListadoCoches);
        lyContListado = findViewById(R.id.lyContListado);

        fabComparar.setY(250);

        listaCoches.setAdapter(new CochesAdapter(modelo.listadoCoches));
        listaCoches.setLayoutManager(new LinearLayoutManager(this));
        listaCoches.setHasFixedSize(false);

    }

    private class CochesAdapter extends RecyclerView.Adapter<CochesAdapter.ViewHolder> {

        private ArrayList<Coche> coches;

        public CochesAdapter(ArrayList<Coche> coches) {
            this.coches = coches;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public ImageView imgCoche;
            public TextView txtModelo, txtMotor, txtCombustible, txtPrecio;
            public Button btnSeleccionar;
            private Context context;

            public ViewHolder (Context context, View itemView) {
                super(itemView);

                imgCoche = itemView.findViewById(R.id.imgCoche);
                txtModelo = itemView.findViewById(R.id.txtModelo);
                txtMotor = itemView.findViewById(R.id.txtMotor);
                txtCombustible = itemView.findViewById(R.id.txtCombustible);
                txtPrecio = itemView.findViewById(R.id.txtPrecio);
                btnSeleccionar = itemView.findViewById(R.id.btnSeleccionar);
                btnSeleccionar.setOnClickListener(new onSeleccionarListener(this));
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

    private class onSeleccionarListener implements View.OnClickListener {
        CochesAdapter.ViewHolder itemView;

        public onSeleccionarListener(CochesAdapter.ViewHolder view) {
            this.itemView = view;
        }

        @Override
        public void onClick(View v) {
            int pos = itemView.getAdapterPosition();

            if(modelo.cochesSeleccionados.size() < 2) {
                seleccionarCoche(pos);
            } else {
                mostrarMensajeSeleccionLlena();
            }
        }
    }

    private void seleccionarCoche(int pos) {
        if (!modelo.cochesSeleccionados.contains(modelo.listadoCoches.get(pos))) {
            modelo.cochesSeleccionados.add(modelo.listadoCoches.get(pos));
            if (modelo.cochesSeleccionados.size() == 1) {
                txtCoche1.setText(modelo.cochesSeleccionados.get(0).getModelo());
            } else {
                txtCoche2.setText(modelo.cochesSeleccionados.get(1).getModelo());
                moverBola(0);
            }
        }
    }

    private void mostrarMensajeSeleccionLlena() {
        Toast.makeText(this, R.string.msgSeleccionMasDeDos, Toast.LENGTH_SHORT).show();
    }

    private void onClickItem(int position) {
        Toast.makeText(this, "Click en " + position, Toast.LENGTH_SHORT).show();
    }

    private void moverBola(int pos) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(fabComparar, "translationY", pos);
        animation.setDuration(500);
        animation.start();
    }

    public void quitarCoche1 (View view) {
        if (!txtCoche1.getText().equals("")) {
            modelo.cochesSeleccionados.remove(0);
            if(modelo.cochesSeleccionados.size() == 0) {
                txtCoche1.setText("");
            } else {
                txtCoche1.setText(modelo.cochesSeleccionados.get(0).getModelo());
                txtCoche2.setText("");
                moverBola(250);
            }
        }
    }

    public void quitarCoche2 (View view) {
        if (!txtCoche2.getText().equals("")) {
            txtCoche2.setText("");
            modelo.cochesSeleccionados.remove(1);
            moverBola(250);
        }
    }
}
