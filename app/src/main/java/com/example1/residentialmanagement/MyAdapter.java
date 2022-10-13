package com.example1.residentialmanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<DatareferenceMaintenance> list;

    public MyAdapter(Context context, ArrayList<DatareferenceMaintenance> datareferenceMaintenances) {
        this.context = context;
        this.list = datareferenceMaintenances ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.maintenancecard,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        DatareferenceMaintenance datareferenceMaintenance = list.get(position);
        holder.mnth.setText(datareferenceMaintenance.getMonth());
        holder.yr.setText(datareferenceMaintenance.getYear());
        holder.amt.setText(datareferenceMaintenance.getAmount());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,MaintenanceDetail.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mnth,yr,amt;
        CardView cardView;
        public MyViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.c1);
            mnth = itemView.findViewById(R.id.maintenancecard_textview_month);
            yr = itemView.findViewById(R.id.maintanancecard_textview_year);
            amt = itemView.findViewById(R.id.maintainancecard_textview_amount);
        }

    }
}