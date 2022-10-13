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

public class AddExpenseBill extends AppCompatActivity {

    Button b1;
    Spinner s1;
    EditText a,t;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense_bill);
        getSupportActionBar().setTitle("Add Expense Bill");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b1 = findViewById(R.id.addexpense_button_addnewbill);
        s1 = findViewById(R.id.addexpense_spinner_month);
        a = findViewById(R.id.addexpense_edittext_enteramount);
        t = findViewById(R.id.addexpense_edittext_enteryear);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m= s1.getSelectedItem().toString();
                String title = t.getText().toString();
                String amount = a.getText().toString();

                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(MainActivity.getUsernumber()).child("CA").child(Create_Apartment.getId());
                BillExpense billExpense = new BillExpense(m,title,amount);
                String id = databaseReference.push().getKey();
                databaseReference.child("Expenses").child("Bills").child(id).setValue(billExpense)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(AddExpenseBill.this, "record added", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(AddExpenseBill.this,Expenses.class));
                                        finish();
                                    }
                                });
            }
        });
    }
}