package com.example.kytc.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SalaryDao {
    @Insert
    void InsertSalary(Salary salary);
    @Update
    void updateSalary(Salary salary);
    @Delete
    void deleteSalary(Salary salary);
    @Query("select * from  Salary where empId =:emp_id")
    LiveData<List<Salary>> getEmployeeSalaries(long emp_id);

}
