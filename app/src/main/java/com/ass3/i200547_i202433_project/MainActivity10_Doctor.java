package com.ass3.i200547_i202433_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity10_Doctor extends AppCompatActivity {

    ImageButton l1, l2, l3, l4, l6, l7, l8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doctor);
        l1 = (ImageButton) findViewById(R.id.z21);
        l2 = (ImageButton) findViewById(R.id.z24);
        l3 = (ImageButton) findViewById(R.id.z26);
        l4 = (ImageButton) findViewById(R.id.z27);
        l6 = (ImageButton) findViewById(R.id.lll1);
        l7 = (ImageButton) findViewById(R.id.lll2);
        l8 = (ImageButton) findViewById(R.id.lll3);


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Activity1();}
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Activity1();}
        });
    }

    public void Activity1(){
        Intent intent = new Intent(this, MainActivity6_Home.class);
        startActivity(intent);
    }
    public void Activity2(){
        Intent intent = new Intent(this, MainActivity7_Exercise.class);
        startActivity(intent);
    }
    public void Activity3(){
        Intent intent = new Intent(this, MainActivity5_Settings.class);
        startActivity(intent);
    }
}