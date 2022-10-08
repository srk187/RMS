package com.example1.residentialmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.DesignTool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.lang.reflect.Member;

public class dashboard_CYA extends AppCompatActivity {
    ImageButton maintenance,summary,expense,rules,decision,announce,member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_cya);

        maintenance = findViewById(R.id.dashboard_cya_imgbtn_mtn);
        summary = findViewById(R.id.btnSmr);
        expense = findViewById(R.id.btnExn);
        rules = findViewById(R.id.btnRules);
        decision = findViewById(R.id.btnPoll);
        announce = findViewById(R.id.btnAnc);
        member = findViewById(R.id.btnMember);

        getSupportActionBar().setTitle("Dashboard");

        maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_CYA.this, maintenance.class));

            }
        });

        summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_CYA.this, Summary.class));

            }
        });

        expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_CYA.this, Expenses.class));

            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_CYA.this, Rules.class));

            }
        });

        decision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_CYA.this, DecisionPoll.class));

            }
        });

        announce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_CYA.this, Announcement.class));

            }
        });

        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard_CYA.this, Member.class));

            }
        });

    }
}