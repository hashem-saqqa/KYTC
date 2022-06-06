package com.example.kytc.RoomDataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = {@ForeignKey(entity = Employee.class,parentColumns = {"id"},childColumns = {"empId"} ,onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE)})
public class Salary {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private double amount;
    private String date;
    private long empId;

    public Salary(double amount, String date, long empId) {
        this.amount = amount;
        this.date = date;
        this.empId = empId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }
}
