package com.example1.residentialmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<BillMaintain> list;

    public MyAdapter(Context context, ArrayList<BillMaintain> bills) {
        this.context = context;
        this.list = bills;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.maintenancecard,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
            BillMaintain bill = list.get(position);
            holder.month.setText(bill.getMonth());
            holder.year.setText(bill.getYear());
            holder.amount.setText(bill.getAmount());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView month,year,amount;
        public MyViewHolder(View itemView){
            super(itemView);
            month = itemView.findViewById(R.id.monthtxt);
            year = itemView.findViewById(R.id.yeartxt);
            amount = itemView.findViewById(R.id.txtamt);
        }

    }
}