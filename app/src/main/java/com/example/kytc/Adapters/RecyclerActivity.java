package com.example.kytc.Adapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kytc.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView students_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        students_rv = findViewById(R.id.students_rv);

        ArrayList<Student> students = (ArrayList<Student>) getIntent().getBundleExtra("students").getSerializable("ARRAYLIST");

        RvAdapter rvAdapter = new RvAdapter(students);

        students_rv.setAdapter(rvAdapter);

        students_rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


    }
}