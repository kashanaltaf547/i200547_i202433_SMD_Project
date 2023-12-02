package com.ass3.i200547_i202433_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity5_Settings extends AppCompatActivity {

    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9;

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);

        b1 = (Button) findViewById(R.id.e40);

        linearLayout1 = findViewById(R.id.e8);
        linearLayout2 = findViewById(R.id.e12);
        linearLayout3 = findViewById(R.id.e16);
        linearLayout4 = findViewById(R.id.e20);
        linearLayout5 = findViewById(R.id.e25);
        linearLayout6 = findViewById(R.id.e29);
        linearLayout7 = findViewById(R.id.e34);
        linearLayout8 = findViewById(R.id.e38);
        linearLayout9 = findViewById(R.id.e42);


        linearLayout1.getBackground().setAlpha(120);
        linearLayout2.getBackground().setAlpha(120);
        linearLayout3.getBackground().setAlpha(120);
        linearLayout4.getBackground().setAlpha(120);
        linearLayout5.getBackground().setAlpha(120);
        linearLayout6.getBackground().setAlpha(120);
        linearLayout7.getBackground().setAlpha(120);
        linearLayout8.getBackground().setAlpha(120);
        linearLayout9.getBackground().setAlpha(120);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Activity1();}
        });
    }
    public void Activity1(){
        Intent intent = new Intent(this, MainActivity4_SignUp.class);
        startActivity(intent);
    }
}