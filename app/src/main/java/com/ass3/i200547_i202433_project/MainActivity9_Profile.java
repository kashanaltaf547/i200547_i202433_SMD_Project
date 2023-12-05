package com.ass3.i200547_i202433_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity9_Profile extends AppCompatActivity {
    Button b1;
    TextView name, email, pass, dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit_profile);

        b1 = (Button) findViewById(R.id.f23);

        showUserData();

    }
    public void showUserData(){
        Intent intent = getIntent();

        String usernameUser = intent.getStringExtra("username");
        String emailUser = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String dateOfBirth = intent.getStringExtra("dob");

        name.setText(usernameUser);
        email.setText(emailUser);
        pass.setText(password);
        dob.setText(dateOfBirth);
    }
    public void passUserData(){
        String username = name.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Query checkUserDatabase = reference.orderByChild("username").equalTo(username);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String nameFromDB = snapshot.child(username).child("username").getValue(String.class);
                    String emailFromDB = snapshot.child(username).child("email").getValue(String.class);
                    String passFromDB = snapshot.child(username).child("password").getValue(String.class);
                    String dobFromDB = snapshot.child(username).child("dob").getValue(String.class);

                    Intent intent = new Intent(MainActivity9_Profile.this, MainActivity8_EditProfile.class);
                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("password", passFromDB);
                    intent.putExtra("dob", dobFromDB);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}