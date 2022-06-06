package com.example.kytc.Sharedpreferences101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kytc.R;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {
    RecyclerView names_rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_v);

        names_rv = findViewById(R.id.names_rv);

        ArrayList<String> names = new ArrayList<>();
        names.add("ahmed");
        names.add("anas");
        names.add("essa");
        names.add("moahmmed");

        RvAdapter rvAdapter = new RvAdapter(RVActivity.this,names);

        names_rv.setAdapter(rvAdapter);


        names_rv.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false));




    }
}