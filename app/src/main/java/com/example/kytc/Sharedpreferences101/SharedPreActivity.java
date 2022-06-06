package com.example.kytc.Sharedpreferences101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kytc.R;

public class SharedPreActivity extends AppCompatActivity {
    EditText name_et, age_et;
    Button save_bt, show_bt;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pre);

        name_et = findViewById(R.id.name_et);
        age_et = findViewById(R.id.age_et);
        save_bt = findViewById(R.id.save_bt);
        show_bt = findViewById(R.id.show_bt);

        preferences = getSharedPreferences("MyFile", MODE_PRIVATE);
        editor = preferences.edit();

        save_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_et.getText().toString();
                String age = age_et.getText().toString();

                editor.putString("name", name);
                editor.putString("age", age);
                editor.apply();
            }
        });
        show_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = preferences.getString("name", "no data");
                String age = preferences.getString("age", "no data");

                name_et.setText(name);
                age_et.setText(age);
            }
        });

    }
}