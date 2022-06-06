package com.example.kytc.ThirdProject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kytc.R;

public class InsertActivity extends AppCompatActivity {
    EditText courseNameEt, courseHoursEt, courseSemesterEt;
    Button addBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        courseNameEt = findViewById(R.id.courseNameEt);
        courseHoursEt = findViewById(R.id.courseHoursEt);
        courseSemesterEt = findViewById(R.id.courseSemesterEt);
        addBt = findViewById(R.id.addBt);

        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseName = courseNameEt.getText().toString();
                int courseHours = Integer.parseInt(courseHoursEt.getText().toString());
                int courseSemester = Integer.parseInt(courseSemesterEt.getText().toString());


                ThirdProjectDatabase db = new ThirdProjectDatabase(InsertActivity.this);
                db.insertCourse(courseName, courseHours, courseSemester);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(getBaseContext(), ShowAllCourses.class);
        startActivity(intent);
        return true;
    }
}