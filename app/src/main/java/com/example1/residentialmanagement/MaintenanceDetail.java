package com.example1.residentialmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.Query;

public class MaintenanceDetail extends AppCompatActivity {

    Button paid,collect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_detail);

        paid = findViewById(R.id.maintenancedetail_button_paid);
        collect = findViewById(R.id.maintenancedetail_button_collect);
        paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

            }
        });
    }
}