package com.ass3.i200547_i202433_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class MainActivity8_EditProfile extends AppCompatActivity {
    ImageView i1;
    ImageButton l1;
    EditText e1, e2, e3, e4;
    Button b1;
    String username, email, pass, dob;
    DatabaseReference reference;
    Uri ImageUri;
    StorageReference storageReference;

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

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePic();
            }
        });

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
            l1.setImageURI(ImageUri);
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