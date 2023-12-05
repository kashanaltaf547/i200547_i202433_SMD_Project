package com.ass3.i200547_i202433_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.UUID;

public class MainActivity4_SignUp extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    ImageButton i1, i2;
    ImageView l1, l2, l3, l4;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    Uri ImageUri;
    FirebaseStorage storage;
    StorageReference storageReference;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        b1 = (Button) findViewById(R.id.c5);
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
        l4 = (ImageView) findViewById(R.id.c6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePic();
            }
        });

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
        public void choosePic() {
            Intent intent = new Intent();
            intent.setType("/image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, 1);
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 1 && resultCode == RESULT_OK && data!=null && data.getData() != null){
                ImageUri = data.getData();
                l4.setImageURI(ImageUri);
                uploadPic();
            }
        }
        public void uploadPic(){

            final ProgressDialog pd = new ProgressDialog(this);
            pd.setTitle("Uploading Image...");
            pd.show();

            final String randomKey = UUID.randomUUID().toString();
            StorageReference riversRef = storageReference.child("images/" + randomKey);

            riversRef.putFile(ImageUri).
                    addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            pd.dismiss();
                            Snackbar.make(findViewById(android.R.id.content), "Image Uploaded", Snackbar.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            pd.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed to upload", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progressPercent = (100.00 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            pd.setMessage("Percentage" + (int) progressPercent + "%");
                        }
                    });
        }
}