package com.example1.residentialmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class MainActivity extends AppCompatActivity {
    static TextInputEditText username, password;
    TextView register,mobileEror, passError;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.Activity_main_edittext_username);
        password = findViewById(R.id.Activity_main_edittext_password);
        register = findViewById(R.id.Activity_main_textview_register);
        login =  findViewById(R.id.Activity_main_button_login);
        mobileEror =  findViewById(R.id.Activity_main_textview_usernameError);
        passError =  findViewById(R.id.Activity_main_textview_passwordError);


//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot snapshot1 : snapshot.getChildren()){
//                    String key = snapshot1.getKey();
//                    reference.child(key).child("CA").addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot2) {
//                            for(DataSnapshot snapshot3 : snapshot2.getChildren()){
//                                String key2 = snapshot3.getValue().toString();
//                                System.out.println(key2);
//
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        getSupportActionBar().setTitle("Login");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg_num = new Intent(MainActivity.this, registerNumber.class);
                startActivity(reg_num);
                finish();
            }
        });
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(username.getText().toString().length() != 10){
                    mobileEror.setVisibility(View.VISIBLE);
                }
                if(username.getText().toString().length() == 10){
                    mobileEror.setVisibility(View.INVISIBLE);
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(password.getText().toString().length() < 6){
                    passError.setVisibility(View.VISIBLE);
                }
                if(password.getText().toString().length() >= 6){
                    passError.setVisibility(View.INVISIBLE);
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passError.getVisibility() == View.INVISIBLE & mobileEror.getVisibility() == View.INVISIBLE)
                {
                    Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                    login();
                }

            }
        });

    }

    private void login() {
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("mobile_number").equalTo("+91" + username.getText().toString().trim());

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String systempassword = snapshot.child("+91"+ username.getText().toString()).child("password").getValue(String.class);
                    if(password.getText().toString().trim().equals(systempassword)){
                        startActivity(new Intent(MainActivity.this, connect.class));
                        finish();
                    }else {
                        Toast.makeText(MainActivity.this, "password does not match", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Username or Password is Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
    public static String getUsernumber(){
        return "+91"+ username.getText().toString();
    }
}