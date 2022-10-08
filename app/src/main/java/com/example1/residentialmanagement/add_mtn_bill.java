package com.example1.residentialmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class add_mtn_bill extends AppCompatActivity {
Spinner month;
EditText year;
TextInputEditText amount;
Button addbill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mtn_bill);
        getSupportActionBar().setTitle("Add Maintenance Bill");

        month = findViewById(R.id.addbill_spinner_month);
        year = findViewById(R.id.addbill_edittext_year);
        amount = findViewById(R.id.addbill_edittext_amount);
        addbill = findViewById(R.id.addbill_button_add);

        addbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(MainActivity.getUsernumber()).child("CA").child(Create_Apartment.getId());

                BillMaintain bill =new BillMaintain(month.getSelectedItem().toString(),year.getText().toString(),amount.getText().toString());

                String id = databaseReference.push().getKey();
                databaseReference.child("Maintenance").child("Bills").child(id).setValue(bill);

                startActivity(new Intent(add_mtn_bill.this, maintenance.class));
                finish();
            }
        });
    }
}