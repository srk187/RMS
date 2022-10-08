package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Create_Apartment extends AppCompatActivity {
    static TextInputEditText name, state,city,address;
    Button next;
    String check;
    static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apartment);
        getSupportActionBar().setTitle("Create Apartment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.create_apartment_edt_aptname);
        state = findViewById(R.id.create_apartment_edt_state);
        city = findViewById(R.id.create_apartment_edt_city);
        address = findViewById(R.id.create_apartment_edt_address);

        next = findViewById(R.id.create_apartment_btn_next);

        check = MainActivity.getUsernumber();

        getSupportActionBar().setTitle("Create Apartment");


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

        }

    private void insert() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(check);

        id = databaseReference.push().getKey();
        add_apartment apartment = new add_apartment(name.getText().toString(),state.getText().toString(),city.getText().toString(),address.getText().toString());

        databaseReference.child("CA").child(id).setValue(apartment);

        Intent i = new Intent(Create_Apartment.this, select_homedetail.class);
        startActivity(i);
        finish();

    }

    public static String getApartmentName(){
        return name.getText().toString();
    }

    public static String getId(){
        return id;
    }
}