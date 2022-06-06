package com.example.kytc.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    EmployeeDAO employeeDAO;
    SalaryDao salaryDao;

    public Repository(Application application) {
        MyDataBase db = MyDataBase.getDatabase(application);
        employeeDAO = db.employeeDAO();
        salaryDao = db.salaryDao();
    }

    void insertEmployee(Employee... employee) {
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.insertEmployee(employee);
            }
        });
    }

    void updateEmployee(Employee... employee) {
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.updateEmployee(employee);
            }
        });
    }

    void deleteEmployee(Employee... employee) {
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.deleteEmployee(employee);
            }
        });
    }

    void deleteEmployee(String email) {
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDAO.deleteEmployee(email);
            }
        });
    }

    LiveData<List<Employee>> getAllEmployee() {

       return employeeDAO.getAllEmployee();
    }

    void InsertSalary(Salary salary) {
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDao.InsertSalary(salary);
            }
        });
    }

    void updateSalary(Salary salary) {
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDao.updateSalary(salary);
            }
        });
    }

    void deleteSalary(Salary salary) {
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDao.deleteSalary(salary);
            }
        });
    }

    LiveData<List<Salary>> getEmployeeSalaries(long emp_id) {
       return salaryDao.getEmployeeSalaries(emp_id);
    }
}
