package com.example.kytc.ThirdProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kytc.R;

import java.util.ArrayList;

public class EditCourseActivity extends AppCompatActivity {
    EditText courseNameEt, courseHoursEt, courseSemesterEt;
    Button updateBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);
        courseNameEt = findViewById(R.id.courseNameEt);
        courseHoursEt = findViewById(R.id.courseHoursEt);
        courseSemesterEt = findViewById(R.id.courseSemesterEt);
        updateBt = findViewById(R.id.updateBt);

       int id = getIntent().getIntExtra("id",0);
       String name = getIntent().getStringExtra("name");
       int hours = getIntent().getIntExtra("hours",0);
       int semester = getIntent().getIntExtra("semester",0);
       int position = getIntent().getIntExtra("position",0);
//        Context context = (Context) getIntent().getSerializableExtra("context");
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();

       courseNameEt.setText(name);
       courseHoursEt.setText(""+hours);
       courseSemesterEt.setText(""+semester);

       ThirdProjectDatabase db = new ThirdProjectDatabase(this);

        updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseName = courseNameEt.getText().toString();
                int courseHours = Integer.parseInt(courseHoursEt.getText().toString());
                int courseSemester = Integer.parseInt(courseSemesterEt.getText().toString());

                db.updateCourse(id,courseName,courseHours,courseSemester);
                ShowAllCourses.courses = (ArrayList<Course>) db.getAllCourses();
                ShowAllCourses.courseRv.setAdapter(new CourseAdapter(ShowAllCourses.courses));
                finish();

            }
        });
    }
}