package com.example.kytc.ThirdProject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ThirdProjectDatabase extends SQLiteOpenHelper {
    public ThirdProjectDatabase(@Nullable Context context) {
        super(context, "CoursesDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table Courses(id integer primary key autoincrement, name text, hours integer, semester integer )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertCourse(String name ,int hours,int semester){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("hours",hours);
        cv.put("semester",semester);
        db.insert("Courses",null,cv);
    }
    public void updateCourse(int id,String name ,int hours,int semester){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("hours",hours);
        cv.put("semester",semester);
        String[] args = {""+id};
        db.update("Courses",cv,"id = ?",args);
    }
    public void deleteCourse(int id){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        String[] args = {""+id};
        db.delete("Courses","id = ?",args);
    }
    public List<Course> getAllCourses(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from Courses",null);
        ArrayList<Course> courses = new ArrayList<>();

        while (c.moveToNext()){

           int id = c.getInt(0);
           String name = c.getString(1);
           int hours = c.getInt(2);
           int semester = c.getInt(3);

           Course course = new Course(name,hours,semester);
           course.setId(id);

           courses.add(course);

        }
        return courses;
    }
    public List<Course> getCoursesBySemester(int semester2){
        SQLiteDatabase db = getReadableDatabase();
        String[] args = {""+semester2};
        Cursor c = db.rawQuery("Select * from Courses where semester = ?",args);
        ArrayList<Course> courses = new ArrayList<>();

        while (c.moveToNext()){

            int id = c.getInt(0);
            String name = c.getString(1);
            int hours = c.getInt(2);
            int semester = c.getInt(3);

            Course course = new Course(name,hours,semester);
            course.setId(id);

            courses.add(course);

        }
        return courses;
    }

}
