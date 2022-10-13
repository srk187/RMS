package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Maintenance extends AppCompatActivity {

    ImageButton addbill;
    ArrayList<DatareferenceMaintenance> list;
    MyAdapter adapter;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);
        getSupportActionBar().setTitle("Maintenance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addbill = findViewById(R.id.maintenance_imagebutton_add);
        recyclerView = findViewById(R.id.maintenance_recycleview_r1);
        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(MainActivity.getUsernumber()).child("CA").child(Create_Apartment.getId());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        databaseReference.child("Maintenance").child("Bills").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    DatareferenceMaintenance datareferenceMaintenance = dataSnapshot.getValue(DatareferenceMaintenance.class);
                    list.add(datareferenceMaintenance);
                }adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        addbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Maintenance.this,AddMaintenanceBIll.class));
                finish();
            }
        });
    }
}