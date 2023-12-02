package com.ass3.i200547_i202433_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity6_Home extends AppCompatActivity {
    CalendarView calendarView;
    Calendar calendar;
    ImageButton i1, i2, i3, i4 ,i5, i6;
    Button b1, b2, b3, b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        calendarView = (CalendarView) findViewById(R.id.calendarview);
        i1 = (ImageButton) findViewById(R.id.z21) ;
        i2 = (ImageButton) findViewById(R.id.z23);
        i3 = (ImageButton) findViewById(R.id.z24);
        i4 = (ImageButton) findViewById(R.id.z26);
        i5 = (ImageButton) findViewById(R.id.z27);
        b1 = (Button) findViewById(R.id.z8);
        b2 = (Button) findViewById(R.id.z11);
        b3 = (Button) findViewById(R.id.z14);
        b4 = (Button) findViewById(R.id.z17);
        i6 = (ImageButton) findViewById(R.id.z90);
        calendar = Calendar.getInstance();

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity3();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity2(); }
        });

        setDate(2, 12, 2023);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity6_Home.this, dayOfMonth + "/" + month+1 + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void getDate(){
        long date = calendarView.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this, selected_date, Toast.LENGTH_SHORT).show();
    }
    public void setDate(int dayOfMonth, int month, int year){
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        long milli = calendar.getTimeInMillis();
        calendarView.setDate(milli);
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