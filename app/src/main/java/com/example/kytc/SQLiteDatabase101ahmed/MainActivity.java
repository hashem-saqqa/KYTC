package com.example.kytc.SQLiteDatabase101ahmed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kytc.R;

public class MainActivity extends AppCompatActivity {
    EditText carNameEt,carColorEt,carYearEt;
    Button addBt,updateBt,deleteBt;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        carNameEt  = findViewById(R.id.carNameEt);
        carColorEt  = findViewById(R.id.carColorEt);
        carYearEt  = findViewById(R.id.carYearEt);
        addBt  = findViewById(R.id.addBt);
        updateBt = findViewById(R.id.updateBt);
        deleteBt = findViewById(R.id.deleteBt);

        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = carNameEt.getText().toString();
                String color = carColorEt.getText().toString();
                String year = carYearEt.getText().toString();

                MyDatabase db = new MyDatabase(MainActivity.this);
                boolean result = db.insertCar(name,color,year);
                if (result){
                    Toast.makeText(MainActivity.this, "insertion done", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "insertion failed", Toast.LENGTH_SHORT).show();

                }

            }
        });
        updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = carNameEt.getText().toString();
                String color = carColorEt.getText().toString();
                String year = carYearEt.getText().toString();
                MyDatabase db = new MyDatabase(MainActivity.this);
                db.updateCar(name,color,year);
            }
        });
        deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = carNameEt.getText().toString();
                MyDatabase db = new MyDatabase(MainActivity.this);
               boolean result = db.deleteCar(name);
                if (result){
                    Toast.makeText(MainActivity.this, "delete operation done successfully", Toast.LENGTH_SHORT).show();
                  long carsCount = db.getCarsCount();
                    Log.d("theNumberOfRows", ""+carsCount);
                }else{
                    Toast.makeText(MainActivity.this, "delete operation failed", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}