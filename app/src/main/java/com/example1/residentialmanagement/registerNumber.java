package com.example1.residentialmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class registerNumber extends AppCompatActivity {
    android.widget.Button send;
    static TextInputEditText mobile;
    static CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_number);
        getSupportActionBar().setTitle("Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mobile = findViewById(R.id.registerno_textinputedittext_mobileno);
        send = findViewById(R.id.registerno_button_sendotp);
        ccp = findViewById(R.id.registerno_ccp_layout);

        ccp.registerCarrierNumberEditText(mobile);

        getSupportActionBar().setTitle("Registration");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mobile.getText().toString().isEmpty()){
                    mobile.setError("Please enter mobile number");
                }else if(mobile.getText().toString().length() < 10){
                    mobile.setError("Please enter valid number");
                }else{

                    Intent otp = new Intent(registerNumber.this,otp_verify.class);
                    otp.putExtra("mobile_number",ccp.getFullNumberWithPlus().replace(" ",""));
                    startActivity(otp);
                    finish();
                }
            }
        });
    }
    public static String getNumber(){
        return ccp.getFullNumberWithPlus().replace(" ","");
    }
}