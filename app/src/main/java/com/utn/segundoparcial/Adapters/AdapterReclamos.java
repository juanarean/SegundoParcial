package com.utn.segundoparcial.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utn.segundoparcial.Classes.DialogInfo;
import com.utn.segundoparcial.Classes.Reclamo;
import com.utn.segundoparcial.Main2Activity;
import com.utn.segundoparcial.R;

import java.util.List;

public class AdapterReclamos extends RecyclerView.Adapter <AdapterReclamos.ReclamosViewHolder>{

    private List<Reclamo> Reclamos;
    private Context mContext;
    private int item;

    public AdapterReclamos(List<Reclamo> reclamos) {
        Reclamos = reclamos;
    }

    @NonNull
    @Override
    public ReclamosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_reclamos,parent,false);
        ReclamosViewHolder holder = new ReclamosViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReclamosViewHolder holder, int position) {
        final Reclamo reclamo = Reclamos.get(position);
        holder.tvCliente.setText(reclamo.getCliente());
        holder.tvReclamo.setText(reclamo.getID());
        if(!reclamo.getEstado())
            holder.tvReclamo.setTextColor(ContextCompat.getColor(mContext, R.color.texterror));
        else
            holder.tvReclamo.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));

        item = position;

        String URL = reclamo.getLogo();

        holder.btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((FragmentActivity)mContext).getSupportFragmentManager();
                DialogFragment dialogo = new DialogInfo();
                DialogInfo.setDetalle(reclamo.getDetalle());
                dialogo.show(fragmentManager, "tagAlerta");
            }
        });

        holder.btnAtender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(mContext, Main2Activity.class);
                intent.putExtra("URL", URL);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Reclamos.size();
    }

    public static class ReclamosViewHolder extends RecyclerView.ViewHolder {

        TextView tvCliente;
        TextView tvReclamo;
        ImageView logoCliente;
        ImageButton btnAtender, btnDetalle;

        public ReclamosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCliente = itemView.findViewById(R.id.tvCliente);
            tvReclamo = itemView.findViewById(R.id.tvReclamo);
            //logoCliente = itemView.findViewById(R.id.ivLogoCliente);
            btnAtender = itemView.findViewById(R.id.btnAtender);
            btnDetalle = itemView.findViewById(R.id.btnDetalle);

        }
    }

    public void ImageGalleryAdapter(Context context) {
        mContext = context;
    }
}
