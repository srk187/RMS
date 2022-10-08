package com.example1.residentialmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Announcement extends AppCompatActivity {
    ImageButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        getSupportActionBar().setTitle("Announcement");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1 = findViewById(R.id.btnAddAnnouncement);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Announcement.this,Add_Announcement.class);
                startActivity(i);
                finish();
            }
        });
    }
}