package com.example1.residentialmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class connect extends AppCompatActivity {
    Button btnCreateApartment,btnJoinApartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect);
        getSupportActionBar().setTitle("Connect");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCreateApartment = findViewById(R.id.connect_btn_CYA);
        btnJoinApartment = findViewById(R.id.connect_btn_JA);

        getSupportActionBar().setTitle("Connect");

        btnCreateApartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(connect.this,Create_Apartment.class));
                finish();
            }
        });

        btnJoinApartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(connect.this,Join_Apartment.class));
                finish();
            }
        });
    }
}