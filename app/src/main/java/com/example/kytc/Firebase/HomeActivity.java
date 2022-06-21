package com.example.kytc.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.kytc.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();
        Log.d("testt", "onCreate: "+auth.getCurrentUser().getDisplayName());
        Log.d("testt", "onCreate: "+auth.getCurrentUser().getEmail());
        Log.d("testt", "onCreate: "+auth.getCurrentUser().getPhoneNumber());
        Log.d("testt", "onCreate: "+auth.getCurrentUser().getUid());
        Log.d("testt", "onCreate: "+auth.getCurrentUser().getPhotoUrl());



    }
}