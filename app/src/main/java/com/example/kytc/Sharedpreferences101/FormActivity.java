package com.example.kytc.Sharedpreferences101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.kytc.R;

public class FormActivity extends AppCompatActivity {
    EditText name_et, email_et, age_et, id_et;
    Button submit_bt;
    String name, age, id, email;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name_et = findViewById(R.id.name_et);
        email_et = findViewById(R.id.email_et);
        age_et = findViewById(R.id.age_et);
        id_et = findViewById(R.id.id_number_et);
        submit_bt = findViewById(R.id.submit_bt);

        preferences = getSharedPreferences("formData", MODE_PRIVATE);
        editor = preferences.edit();
        // !false = true
//        !true = false
        if (!preferences.getString("name", "no data").equals("no data"))
            name_et.setText(preferences.getString("name", "no data"));
        if (!preferences.getString("name", "no data").equals("no data"))
            email_et.setText(preferences.getString("email", "no data"));
        if (!preferences.getString("name", "no data").equals("no data"))
            age_et.setText(preferences.getString("age", "no data"));
        if (!preferences.getString("name", "no data").equals("no data"))
            id_et.setText(preferences.getString("id", "no data"));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        name = name_et.getText().toString();
        email = email_et.getText().toString();
        age = age_et.getText().toString();
        id = id_et.getText().toString();

        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("age", age);
        editor.putString("id", id);
        editor.apply();


    }
}