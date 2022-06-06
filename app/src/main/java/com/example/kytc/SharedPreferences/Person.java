package com.example.kytc.SharedPreferences;

public class Person {
    private String name;
    private String idNumber;
    private int Age;

    public Person(String name, String idNumber, int age) {
        this.name = name;
        this.idNumber = idNumber;
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
