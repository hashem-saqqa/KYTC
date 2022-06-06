package com.example.kytc.SqliteDatabase;

public class Car {
    private int id;
    private String name;
    private String color;
    private String year;

    public Car(String name, String color, String year) {
        this.name = name;
        this.color = color;
        this.year = year;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
