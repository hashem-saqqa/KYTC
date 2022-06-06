package com.example.kytc.ThirdProject;

public class Course {
    private int id;
    private String name ;
    private int hours;
    private int semester;

    public Course(String name, int hours, int semester) {
        this.name = name;
        this.hours = hours;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
