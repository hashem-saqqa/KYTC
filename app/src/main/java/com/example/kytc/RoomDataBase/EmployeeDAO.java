package com.example.kytc.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EmployeeDAO {
    @Insert
    void insertEmployee(Employee... employee);
    @Update
    void updateEmployee(Employee... employee);
    @Delete
    void deleteEmployee(Employee... employee);
    @Query("delete from employeeTable where email = :email" )
    void deleteEmployee(String email);
    @Query("select * from employeeTable order by name asc " )
    LiveData<List<Employee>> getAllEmployee();
}
