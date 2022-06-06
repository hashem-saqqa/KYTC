package com.example.kytc.RoomDataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "employeeTable")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @NonNull
    private String name;
    private String email;
    private String birthdate;

//    public Employee(long id, @NonNull String name, String email, String birthdate) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.birthdate = birthdate;
//    }
    public Employee(@NonNull String name, String email, String birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
