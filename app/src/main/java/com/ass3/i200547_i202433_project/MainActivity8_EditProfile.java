package com.ass3.i200547_i202433_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity8_EditProfile extends AppCompatActivity {
    ImageView i1;
    ImageButton l1;
    EditText e1, e2, e3, e4;
    Button b1;
    String username, email, pass, dob;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit_profile);

        l1 = (ImageButton) findViewById(R.id.f7);   //cameraButton
        i1 = (ImageView) findViewById(R.id.f6);     //ProfilePic
        e1 = (EditText) findViewById(R.id.f11);
        e2 = (EditText) findViewById(R.id.f14);
        e3 = (EditText) findViewById(R.id.f17);
        e4 = (EditText) findViewById(R.id.f20);
        b1 = (Button) findViewById(R.id.f23);

        reference = FirebaseDatabase.getInstance().getReference();

        showData();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNameChanged() || isEmailChanged() || isPassChanged() || isDOBChanged()){
                    Toast.makeText(MainActivity8_EditProfile.this, "Saved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity8_EditProfile.this, "Changed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isNameChanged() {
        if (!username.equals(e1.getText().toString())) {
            reference.child(username).child("username").setValue(e1.getText().toString());
            username = e1.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmailChanged() {
        if (!email.equals(e2.getText().toString())) {
            reference.child(email).child("email").setValue(e2.getText().toString());
            email = e2.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public boolean isPassChanged() {
        if (!pass.equals(e3.getText().toString())) {
            reference.child(pass).child("password").setValue(e3.getText().toString());
            pass = e3.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public boolean isDOBChanged() {
        if (!dob.equals(e4.getText().toString())) {
            reference.child(dob).child("dob").setValue(e4.getText().toString());
            dob = e4.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    public void showData(){
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        email = intent.getStringExtra("email");
        pass = intent.getStringExtra("password");
        dob = intent.getStringExtra("dob");

        e1.setText(username);
        e2.setText(email);
        e3.setText(pass);
        e4.setText(dob);

    }
}