package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class maintenance extends AppCompatActivity {
    ImageButton addbill;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<BillMaintain> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        getSupportActionBar().setTitle("Maintenance");

        addbill = findViewById(R.id.maintenance_imageview_add);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(MainActivity.getUsernumber()).child("CA").child(Create_Apartment.getId()).child("Maintenance").child("Bills");
        recyclerView = findViewById(R.id.r1);
        list = new ArrayList<>();
        adapter = new MyAdapter(maintenance.this, list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    BillMaintain bill = dataSnapshot.getValue(BillMaintain.class);
                    list.add(bill);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        addbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(maintenance.this,add_mtn_bill.class));
            }
        });


    }
}