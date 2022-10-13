package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMaintenanceBIll extends AppCompatActivity {

    Button maintenancebill;
    DatabaseReference databaseReference;
    EditText amount,year;
    Spinner month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_maintenance_bill);
        getSupportActionBar().setTitle("Add Maintenance Bill");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        maintenancebill = findViewById(R.id.addmainbill_button_addnewbill);
        month = findViewById(R.id.addmaintenancebill_spinner_monthspinner);
        year  = findViewById(R.id.addmaintenancebill_edittext_enteryear);
        amount = findViewById(R.id.addmaintenancebill_edittext_enteramount);

        maintenancebill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m = month.getSelectedItem().toString(),y= year.getText().toString(),a= amount.getText().toString();
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(MainActivity.getUsernumber()).child("CA").child(Create_Apartment.getId());;


                DatareferenceMaintenance bill = new DatareferenceMaintenance(m,y,a);

                String id = databaseReference.push().getKey();
                databaseReference.child("Maintenance").child("Bills").child(id).setValue(bill)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(AddMaintenanceBIll.this, "Bill Added", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(AddMaintenanceBIll.this, Maintenance.class));
                                }
                            }
                        });
            }
        });
    }
}