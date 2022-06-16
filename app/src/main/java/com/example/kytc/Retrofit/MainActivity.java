package com.example.kytc.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.kytc.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        String url = "https://jsonplaceholder.typicode.com/";
    }
}