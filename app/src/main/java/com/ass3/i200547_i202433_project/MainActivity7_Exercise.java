package com.ass3.i200547_i202433_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity7_Exercise extends AppCompatActivity {
    ImageButton i1, i2, i3, i4, i5, i6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_exercise);
        i1 = (ImageButton) findViewById(R.id.zz41);
        i2 = (ImageButton) findViewById(R.id.zz34);
        i3 = (ImageButton) findViewById(R.id.zz36);
        i4 = (ImageButton) findViewById(R.id.zz37);
        i5 = (ImageButton) findViewById(R.id.zz39);
        i6 = (ImageButton) findViewById(R.id.zz40);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity2(); }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity2(); }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity2(); }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity2(); }
        });
    }
    public void Activity1(){
        Intent intent = new Intent(this, MainActivity5_Settings.class);
        startActivity(intent);
    }
    public void Activity2(){
        Intent intent = new Intent(this, MainActivity6_Home.class);
        startActivity(intent);
    }
}