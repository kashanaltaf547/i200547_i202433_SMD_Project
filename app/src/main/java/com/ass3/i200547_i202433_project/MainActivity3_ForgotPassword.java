package com.ass3.i200547_i202433_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3_ForgotPassword extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button b1;
    ImageButton i1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_forgot_password);
        mAuth = FirebaseAuth.getInstance();

        i1 = (ImageButton) findViewById(R.id.a15);
        e1 = (EditText) findViewById(R.id.a9);
        b1 = (Button) findViewById(R.id.a20);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity1();
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = e1.getText().toString().trim();
                if (!TextUtils.isEmpty(Email)) {

                    i1.setVisibility(View.INVISIBLE);

                    mAuth.sendPasswordResetEmail(Email).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(MainActivity3_ForgotPassword.this, "Reset Password Link has been sent to the Email!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(MainActivity3_ForgotPassword.this, MainActivity2_SignIn.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity3_ForgotPassword.this, "Error in resetting password!", Toast.LENGTH_LONG).show();
                                    i1.setVisibility(View.VISIBLE);
                                }
                            });
                } else {
                    e1.setError("Please fill the email!");
                }
            }
        });
    }
        private void Activity1() {
            Intent intent = new Intent(this, MainActivity2_SignIn.class);
            startActivity(intent);
    }
}