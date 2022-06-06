package com.example.kytc.RoomDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends AndroidViewModel {
    Repository repository;
    public MyViewModel(@NonNull Application application) {
        super(application);
         repository = new Repository(application);
    }

    void insertEmployee(Employee... employee) {
       repository.insertEmployee(employee);
    }

    void updateEmployee(Employee... employee) {
        repository.updateEmployee(employee);

    }

    void deleteEmployee(Employee... employee) {
        repository.deleteEmployee(employee);

    }

    void deleteEmployee(String email) {
        repository.deleteEmployee(email);

    }

    LiveData<List<Employee>> getAllEmployee() {

        return repository.getAllEmployee();
    }

    void InsertSalary(Salary salary) {
        repository.InsertSalary(salary);
    }

    void updateSalary(Salary salary) {
        repository.updateSalary(salary);
    }

    void deleteSalary(Salary salary) {
        repository.deleteSalary(salary);
    }

    LiveData<List<Salary>> getEmployeeSalaries(long emp_id) {
        return repository.getEmployeeSalaries(emp_id);
    }
}
