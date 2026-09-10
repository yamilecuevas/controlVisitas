package com.rhsoft.controlvisitas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VisitaAdapter extends RecyclerView.Adapter<VisitaAdapter.VisitaViewHolder> {

    private List<visita> listaVisitas;

    public VisitaAdapter(List<visita> listaVisitas) {
        this.listaVisitas = listaVisitas;
    }

    @NonNull
    @Override
    public VisitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_visita, parent, false);
        return new VisitaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitaViewHolder holder, int position) {
        visita visita = listaVisitas.get(position);
        holder.tvNombre.setText(visita.getNombre());
        holder.tvEmpresa.setText(visita.getEmpresa());
        holder.tvProposito.setText(visita.getProposito());
        holder.tvDni.setText(visita.getDni());
    }

    @Override
    public int getItemCount() {
        return listaVisitas.size();
    }

    public static class VisitaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEmpresa, tvProposito, tvDni;

        public VisitaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEmpresa = itemView.findViewById(R.id.tvEmpresa);
            tvProposito = itemView.findViewById(R.id.tvProposito);
            tvDni = itemView.findViewById(R.id.tvDni);
        }
    }
}
