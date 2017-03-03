package ubahn.joel.ubahnproject.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.model.Estacion;
import ubahn.joel.ubahnproject.view.Estaciones;

/**
 * Created by Usuario on 11/01/2017.
 */
public class RecycleEstaciones extends RecyclerView.Adapter<EstacionesViewHolder> {

    public List<Estacion> listaestaciones;
    Context context;
    RecyclerView mRecycleView;
    public RecycleEstaciones(List<Estacion> listaestaciones, Context c,RecyclerView mRecycle) {

        this.listaestaciones=listaestaciones;
        this.context=c;
        this.mRecycleView=mRecycle;

    }


    @Override
    public EstacionesViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_estacion, parent, false);
        EstacionesViewHolder vh = new EstacionesViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int pos = mRecycleView.getChildAdapterPosition(v);
                Estaciones a = null;
                a = (Estaciones) context;
                a.setNombreEstacion(listaestaciones.get(pos).getNombre());
                a.Cerrar();
            }

        });
        return vh;
    }



    @Override
    public void onBindViewHolder(EstacionesViewHolder holder, int position) {
        holder.nombre.setText(listaestaciones.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaestaciones.size();
    }



}