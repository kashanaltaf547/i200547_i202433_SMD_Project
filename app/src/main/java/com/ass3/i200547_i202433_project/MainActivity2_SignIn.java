package com.ass3.i200547_i202433_project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2_SignIn extends AppCompatActivity {

    EditText username, pass;
    Button b1, b3;
    ImageButton i1;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_in);
        mAuth = FirebaseAuth.getInstance();

        username = (EditText) findViewById(R.id.v9);
        pass = (EditText) findViewById(R.id.v13);
        b1 = (Button) findViewById(R.id.v14);
        i1 = (ImageButton) findViewById(R.id.v15);
        b3 = (Button) findViewById(R.id.v21);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Activity1(); }
        });

        i1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(username.getText());
                password = String.valueOf(pass.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity2_SignIn.this, "Enter Name", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity2_SignIn.this, "Enter Email", Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity2_SignIn.this, "Login Successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity2_SignIn.this, "Login Failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }



    private void Activity1() {
        Intent intent = new Intent(this, MainActivity3_ForgotPassword.class);
        startActivity(intent);
    }
}