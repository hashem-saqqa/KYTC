package com.example.kytc.ThirdProject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kytc.R;

import java.util.ArrayList;

public class ShowAllCourses extends AppCompatActivity {
    static RecyclerView courseRv;
    Spinner semesters;
    CourseAdapter courseAdapter;
    static ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_courses);
        courseRv = findViewById(R.id.courseRv);
        semesters = findViewById(R.id.semesterSpinner);

        ThirdProjectDatabase db = new ThirdProjectDatabase(this);
        courses = (ArrayList<Course>) db.getAllCourses();

        courseAdapter = new CourseAdapter(courses);
        courseRv.setAdapter(courseAdapter);
        courseRv.setLayoutManager(new LinearLayoutManager(ShowAllCourses.this, LinearLayoutManager.VERTICAL, false));

        semesters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    courses = (ArrayList<Course>) db.getAllCourses();
//                    courseRv.setAdapter(new CourseAdapter(courses));
                    courseAdapter.refreshData(courses);
                } else if (i == 1) {
                    courses = (ArrayList<Course>) db.getCoursesBySemester(1);
//                    courseRv.setAdapter(new CourseAdapter(courses));
                    courseAdapter.refreshData(courses);

                } else {
                    courses = (ArrayList<Course>) db.getCoursesBySemester(2);
//                    courseRv.setAdapter(new CourseAdapter(courses));
                    courseAdapter.refreshData(courses);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}