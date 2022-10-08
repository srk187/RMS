package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class select_homedetail extends AppCompatActivity {
    TextInputEditText houseNo, memberNo;
    Button create;
    Spinner htype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_homedetail);
        getSupportActionBar().setTitle("Home Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        houseNo = findViewById(R.id.select_home_detail_edittext_houseno);
        memberNo = findViewById(R.id.select_home_detail_edittext_memberno);

        htype = findViewById(R.id.select_home_detail_spinner_htype);

        create = findViewById(R.id.select_home_detail_button_create);

        getSupportActionBar().setTitle("Select House");

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(MainActivity.getUsernumber());

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String fname = snapshot.child("fname").getValue().toString();
                        String lname = snapshot.child("lname").getValue().toString();

                        String mid = databaseReference.push().getKey();

                        add_member member = new add_member(fname,lname,houseNo.getText().toString(),htype.getSelectedItem().toString(),memberNo.getText().toString());

                        databaseReference.child("CA").child(Create_Apartment.getId().toString()).child("Members").child(mid).setValue(member);

                        house_detail h1 = new house_detail(houseNo.getText().toString(),htype.getSelectedItem().toString(),memberNo.getText().toString());

                        databaseReference.child("CA").child(Create_Apartment.getId().toString()).child("Houses").child(houseNo.getText().toString()).setValue(h1);

                        startActivity(new Intent(select_homedetail.this,dashboard_CYA.class));
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
            }
        });
    }
}