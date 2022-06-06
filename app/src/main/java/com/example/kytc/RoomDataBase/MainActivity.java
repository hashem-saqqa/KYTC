package com.example.kytc.RoomDataBase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kytc.R;

public class MainActivity extends AppCompatActivity {
    EditText employeeNameEt,employeeEmailEt,employeeDobEt;
    Button addBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        employeeNameEt = findViewById(R.id.employeeName);
        employeeEmailEt = findViewById(R.id.employeeEmail);
        employeeDobEt = findViewById(R.id.employeeDOB);
        addBt = findViewById(R.id.addBt);

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employeeName = employeeNameEt.getText().toString();
                String employeeEmail = employeeEmailEt.getText().toString();
                String employeeDOB = employeeDobEt.getText().toString();

                Employee employee = new Employee(employeeName,employeeEmail,employeeDOB);

                myViewModel.insertEmployee(employee);
            }
        });

    }
}