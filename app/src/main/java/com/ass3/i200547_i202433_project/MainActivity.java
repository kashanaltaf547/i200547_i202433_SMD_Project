package com.ass3.i200547_i202433_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    View v1, v2, v3;
    ImageView i1, i2, i3, i4, i5, i6, i7;
    TextView t1, t2;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        v1 = (View) findViewById(R.id.m1);
        v2 = (View) findViewById(R.id.m4);
        t1 = (TextView) findViewById(R.id.m5);
        i1 = (ImageView) findViewById(R.id.m6);
        i2 = (ImageView) findViewById(R.id.m7);
        i3 = (ImageView) findViewById(R.id.m8);
        i4 = (ImageView) findViewById(R.id.m9);
        i5 = (ImageView) findViewById(R.id.m10);
        i6 = (ImageView) findViewById(R.id.m11);
        v3 = (View) findViewById(R.id.m12);
        t2 = (TextView) findViewById(R.id.m13);
        i7 = (ImageView) findViewById(R.id.m14);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainActivity2_SignIn.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}
