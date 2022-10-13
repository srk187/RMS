package com.example1.residentialmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class expenseadapter extends RecyclerView.Adapter<expenseadapter.MyViewHolder> {
    Context context;
    ArrayList<BillExpense> list;

    public expenseadapter(Context context, ArrayList<BillExpense> billExpenses) {
        this.context = context;
        this.list = billExpenses;
    }

    @NonNull
    @Override
    public expenseadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.expensecard,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull expenseadapter.MyViewHolder holder, int position) {
        BillExpense billExpense = list.get(position);
        holder.mnth.setText(billExpense.getMonth());
        holder.title.setText(billExpense.getTitle());
        holder.amt.setText(billExpense.getAmount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mnth,title,amt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mnth = itemView.findViewById(R.id.expensecard_textview_month);
            title = itemView.findViewById(R.id.expensecard_textview_title);
            amt = itemView.findViewById(R.id.expensecard_textview_amount);
        }
    }
}
