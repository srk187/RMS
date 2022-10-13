package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Expenses extends AppCompatActivity {

    ImageButton add;
    ArrayList<BillExpense> list;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    expenseadapter expenseadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        getSupportActionBar().setTitle("Expenses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        add = findViewById(R.id.maintenance_imagebutton_add);
        recyclerView = findViewById(R.id.r1);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(MainActivity.getUsernumber()).child("CA").child(Create_Apartment.getId());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        expenseadapter = new expenseadapter(this,list);
        recyclerView.setAdapter(expenseadapter);

        databaseReference.child("Expenses").child("Bills").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    BillExpense billExpense = dataSnapshot.getValue(BillExpense.class);
                    list.add(billExpense);
                }
                expenseadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Expenses.this, AddExpenseBill.class));
                finish();
            }
        });
    }
}