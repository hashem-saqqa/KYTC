package com.example.kytc.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kytc.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FillDataActivity extends AppCompatActivity {
    EditText name_et, age_et, Id_number_et;
    Button submit_bt,show_bt;
    ArrayList<String> peopleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_data);
        name_et = findViewById(R.id.name_et);
        age_et = findViewById(R.id.age_et);
        Id_number_et = findViewById(R.id.id_number_et);
        submit_bt = findViewById(R.id.submit_bt);
        show_bt = findViewById(R.id.show_bt);

        peopleName = new ArrayList<>();

        SharedPreferences sp = getSharedPreferences("myFile", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        submit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_et.getText().toString();
                String age = age_et.getText().toString();
                String id_number = Id_number_et.getText().toString();
                peopleName.add(name);

                Set<String> people1 = new HashSet<>();
                people1.addAll(peopleName);

                editor.putStringSet("peopleNames",people1);
                editor.apply();
            }
        });
        show_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ViewPeopleActivity.class);
                startActivity(intent);
            }
        });


    }
}