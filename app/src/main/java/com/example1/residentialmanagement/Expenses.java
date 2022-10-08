package com.example1.residentialmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Expenses extends AppCompatActivity {

    ImageButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        getSupportActionBar().setTitle("Expenses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        add = findViewById(R.id.maintenance_imagebutton_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Expenses.this, AddExpenseBill.class));
                finish();
            }
        });
    }
}