package com.utn.segundoparcial.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.utn.segundoparcial.Classes.Reclamo;
import com.utn.segundoparcial.R;

import java.util.List;

public class AdapterReclamos extends RecyclerView.Adapter <AdapterReclamos.ReclamosViewHolder>{

    List<Reclamo> Reclamos;
    private Context mContext;

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
        Reclamo reclamo = Reclamos.get(position);
        holder.tvCliente.setText(reclamo.getCliente());
        Glide.with(mContext).load(reclamo.getLogo()).apply(new RequestOptions().placeholder(R.drawable.logo_basis).dontAnimate()).into(holder.logoCliente);
    }

    @Override
    public int getItemCount() {
        return Reclamos.size();
    }

    public static class ReclamosViewHolder extends RecyclerView.ViewHolder {

        TextView tvCliente;
        ImageView logoCliente;
        Button btnAtender, btnDetalle;

        public ReclamosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCliente = itemView.findViewById(R.id.tvCliente);
            logoCliente = itemView.findViewById(R.id.ivLogoCliente);
            btnAtender = itemView.findViewById(R.id.btnAtender);
            btnDetalle = itemView.findViewById(R.id.btnDetalle);

        }
    }

    public void ImageGalleryAdapter(Context context) {
        mContext = context;
    }
}
