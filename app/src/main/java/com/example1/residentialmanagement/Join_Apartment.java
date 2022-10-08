package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Locale;

public class Join_Apartment extends AppCompatActivity {
    static TextInputEditText name, houseno,nomembers;
    Spinner  htype;
    Button join ;
    String fname, lname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_apartment);
        getSupportActionBar().setTitle("Join Apartment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.join_apartment_edittext_aptname);
        houseno = findViewById(R.id.join_apartment_edittext_houseno);
        htype = findViewById(R.id.join_apartment_spinner_htype);
        nomembers = findViewById(R.id.join_apartment_edittext_memberno);

        join = findViewById(R.id.join_apartment_button_join);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot2) {
                        String key = snapshot2.getKey();
                        fname = snapshot2.child("fname").getValue().toString();
                        lname = snapshot2.child("lname").getValue().toString();

                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                    String key = snapshot.child("mobile_number").getValue().toString();
                                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(key).child("CA");
                                    Query checkUser = reference.orderByChild("name").equalTo(name.getText().toString());

                                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            for(DataSnapshot snapshot1 : snapshot.getChildren()){



                                                add_member member = new add_member(fname,lname,houseno.getText().toString(),htype.getSelectedItem().toString(),nomembers.getText().toString());

                                                house_detail h1 = new house_detail(houseno.getText().toString(),htype.getSelectedItem().toString(),nomembers.getText().toString());

                                                String mid = reference.push().getKey();
                                                reference.child(snapshot1.getKey()).child("Houses").child(houseno.getText().toString()).setValue(h1);
                                                reference.child(snapshot1.getKey()).child("Members").child(mid).setValue(member);

                                                databaseReference.child(MainActivity.getUsernumber()).child("JA").child(name.getText().toString()).setValue(member);

                                                startActivity(new Intent(Join_Apartment.this,dashboard_JA.class));
                                                finish();
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
    }
}