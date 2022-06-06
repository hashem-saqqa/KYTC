package com.example.kytc.SqliteDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kytc.R;

import java.util.ArrayList;

public class AllCars extends AppCompatActivity {
    RecyclerView carsRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cars);
        carsRv = findViewById(R.id.carsRv);
        ArrayList<Car> cars = new MyDataBase(this).getAllCars();
        MyAdapter myAdapter = new MyAdapter(this,cars);

        carsRv.setAdapter(myAdapter);
        carsRv.setLayoutManager(new LinearLayoutManager(this));


    }
}