package com.example.kytc.SqliteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String DBNAME = "cars";

    public MyDataBase(Context context) {
        super(context, "name", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table "+DBNAME+"(id integer primary key autoincrement, name text, color text, year text );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public long insertCar(String name, String color, String year) {
        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("insert into cars(name , color , year) values('" + name + "','" + color + "','" + year + "')");
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("color", color);
        cv.put("year", year);
        long result = db.insert(DBNAME, null, cv);
        return result;
    }

    public int updateCar(String name, String color, String year) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("color", color);
        cv.put("year", year);

        String[] args = {name};
        int result = db.update(DBNAME, cv, "name= ?", args);
        return result;
    }

    public int deleteCar(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {name};
        int result = db.delete(DBNAME, "name=?", args);
        return result;
    }

    public ArrayList<Car> getAllCars() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from "+DBNAME, null);
        ArrayList<Car> cars = new ArrayList<>();

        while (c.moveToNext()) {
            int carId = c.getInt(0);
            String carName = c.getString(1);
            String carColor = c.getString(2);
            String carYear = c.getString(3);
            Car car = new Car(carName, carColor, carYear);
            car.setId(carId);
            cars.add(car);
        }
        return cars;
    }

    public long getCarsCount() {
        SQLiteDatabase db = getReadableDatabase();
        long result = DatabaseUtils.queryNumEntries(db, DBNAME);
        return result;
    }

}
