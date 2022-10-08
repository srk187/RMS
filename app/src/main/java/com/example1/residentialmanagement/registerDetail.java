package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registerDetail extends AppCompatActivity {
    android.widget.Button reg;
    TextInputEditText firstname, lastname, regPassword, regConfPassword,mobile;
    DatabaseReference databaseUSer;
    String phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_detail);
        getSupportActionBar().setTitle("Registration Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reg = findViewById(R.id.register_detail_button_register);
        firstname = findViewById(R.id.register_detail_textinputedittext_firstname);
        lastname = findViewById(R.id.register_detail_textinputedittext_lastname);
        regPassword = findViewById(R.id.register_detail_textinputedittext_password);
        regConfPassword = findViewById(R.id.register_detail_textinputedittext_confirmpassword);

        getSupportActionBar().setTitle("Registration");

        phonenumber = registerNumber.getNumber();

        // below line is used to get the
        // instance of our FIrebase database.

        // below line is used to get reference for our database.

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() || regPassword.getText().toString().isEmpty() || regConfPassword.getText().toString().isEmpty())
                {
                    Toast.makeText(registerDetail.this, "All field are required", Toast.LENGTH_SHORT).show();

                }else if(regPassword.getText().toString().length() <6){
                    Toast.makeText(registerDetail.this, "Password and Confirm password not matched", Toast.LENGTH_SHORT).show();
                }else if(!(regPassword.getText().toString().equals(regConfPassword.getText().toString()))){
                    Toast.makeText(registerDetail.this, "Password and Confirm password not matched", Toast.LENGTH_SHORT).show();
                }else{
                    if(phonenumber.length()  == 0){
                        Toast.makeText(registerDetail.this, "number not matched", Toast.LENGTH_SHORT).show();
                    }else{
                        InsertUser();
                    }

                }
            }
        });
    }

    private void InsertUser() {
        String fname  = firstname.getText().toString();
        String lname  = lastname.getText().toString();
        String pass  = regPassword.getText().toString();

        databaseUSer = FirebaseDatabase.getInstance().getReference("Users").child(phonenumber);


        userRegister user = new userRegister(fname,lname,pass,phonenumber);

        databaseUSer.setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()){
                            startActivity(new Intent(registerDetail.this, MainActivity.class));
                            finish();
                        }
                    }
                });

    }

}