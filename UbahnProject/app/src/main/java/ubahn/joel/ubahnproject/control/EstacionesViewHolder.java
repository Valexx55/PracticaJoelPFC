package ubahn.joel.ubahnproject.control;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ubahn.joel.ubahnproject.R;

/**
 * Created by Usuario on 11/01/2017.
 */
public class EstacionesViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public CardView mCardView;

    ImageView imagenproducto;
    public TextView nombre;
    public EstacionesViewHolder(View v) {
        super(v);
        v.setOnClickListener(this);
        imagenproducto=(ImageView)v.findViewById(R.id.imagen_master);
        mCardView = (CardView) v.findViewById(R.id.card_view);
        nombre = (TextView) v.findViewById(R.id.tv_nombre);


    }
    @Override
    public void onClick(View v) {    }
}