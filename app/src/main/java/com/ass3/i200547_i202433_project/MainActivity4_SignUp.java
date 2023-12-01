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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4_SignUp extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button b1, b2;
    ImageButton i1, i2;
    ImageView l1, l2, l3;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        mAuth = FirebaseAuth.getInstance();


        e1 = (EditText) findViewById(R.id.c9);
        e2 = (EditText) findViewById(R.id.c13);
        e3 = (EditText) findViewById(R.id.c16);
        e4 = (EditText) findViewById(R.id.c19);
        i1 = (ImageButton) findViewById(R.id.c20);
        i2 = (ImageButton) findViewById(R.id.c24);
        l1 = (ImageView) findViewById(R.id.c22);
        l2 = (ImageView) findViewById(R.id.c21);
        l3 = (ImageView) findViewById(R.id.c23);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String name, email, password, phone;
                name = String.valueOf(e1.getText());
                email = String.valueOf(e2.getText());
                password = String.valueOf(e3.getText());
                phone = String.valueOf(e4.getText());

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(MainActivity4_SignUp.this, "Enter Name", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity4_SignUp.this, "Enter Email", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity4_SignUp.this, "Enter Password", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(MainActivity4_SignUp.this, "Enter Country", Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(MainActivity4_SignUp.this, "Authentication created.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity2_SignIn.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity4_SignUp.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity1();
            }
        });

    }

        private void Activity1() {
            Intent intent = new Intent(this, MainActivity2_SignIn.class);
            startActivity(intent);
        }
}