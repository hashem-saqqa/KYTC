package com.example.kytc.SqliteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kytc.R;
import com.example.kytc.databinding.ActivityMain2Binding;

public class MainActivity extends AppCompatActivity {
    EditText carNameEt, carColorEt, carYearEt;
    Button addBt, updateBt, deleteBt, viewAllCarsBt, getAllCarsCountBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        carNameEt = findViewById(R.id.car_name_et);
        carColorEt = findViewById(R.id.car_color_et);
        carYearEt = findViewById(R.id.car_year_et);
        addBt = findViewById(R.id.add_bt);
        updateBt = findViewById(R.id.update_bt);
        deleteBt = findViewById(R.id.delete_bt);
        viewAllCarsBt = findViewById(R.id.viewAllCars);
        getAllCarsCountBt = findViewById(R.id.getAllCarsCountBt);
        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = carNameEt.getText().toString();
                String color = carColorEt.getText().toString();
                String year = carYearEt.getText().toString();

                MyDataBase myDataBase = new MyDataBase(MainActivity.this);
                myDataBase.insertCar(name, color, year);

            }
        });
        updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = carNameEt.getText().toString();
                String color = carColorEt.getText().toString();
                String year = carYearEt.getText().toString();

                MyDataBase myDataBase = new MyDataBase(MainActivity.this);
                myDataBase.updateCar(name, color, year);

            }
        });
        deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = carNameEt.getText().toString();
                MyDataBase myDataBase = new MyDataBase(MainActivity.this);
                myDataBase.deleteCar(name);

            }
        });
        viewAllCarsBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AllCars.class);
                startActivity(intent);
            }
        });
        getAllCarsCountBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDataBase db = new MyDataBase(MainActivity.this);
                long count = db.getCarsCount();
                Toast.makeText(MainActivity.this, "" + count, Toast.LENGTH_SHORT).show();
            }
        });

    }
}