package com.example.kytc.SQLiteDatabase101ahmed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    public static final String DBName = "carDB";
    public static final String carsTable = "cars";
    public static final String nameCol = "name";
    public static final String colorCol = "color";
    public static final String yearCol = "year";
    public static final String speedCol = "speed";
    public static final String powerCol = "power";

    public MyDatabase(@Nullable Context context) {

        super(context, DBName, null, 9);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqllll = "create table " + carsTable + "(id integer primary key autoincrement , " +
                nameCol + " text not null," + " " + colorCol + " text, " + yearCol + " text, " + speedCol + " text )";
        sqLiteDatabase.execSQL(sqllll);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

//        sqLiteDatabase.execSQL("drop table "+carsTable);
//        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("alter table " + carsTable + " add " + powerCol + " text");


    }

    public boolean insertCar(String name, String color, String year) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(nameCol, name);
        cv.put(colorCol, color);
        cv.put(yearCol, year);
        long result = db.insert(carsTable, null, cv);
        boolean r = result != -1; // true
//                               false
        return r;
    }

    public boolean updateCar(String name, String color, String year) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(colorCol, color);
        cv.put(yearCol, year);

        String[] args = {name};
        int result = db.update(carsTable, cv, "name = ?", args);

        return result > 0;
    }

    public boolean deleteCar(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {name};
        int result = db.delete(carsTable, "name = ?", args);
        return result > 0;
    }

    public long getCarsCount() {
        SQLiteDatabase db = getReadableDatabase();
        long carsCount = DatabaseUtils.queryNumEntries(db, carsTable);
        return carsCount;
    }

    public ArrayList<Car> getAllCars() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + carsTable, null);
        ArrayList<Car> cars = new ArrayList<>();

        while (c.moveToNext()) {

            int id = c.getInt(0);
            String name = c.getString(1);
            String color = c.getString(2);
            String year = c.getString(3);

            Car c1 = new Car(id, name, color, year);

            cars.add(c1);

        }
        return cars;
    }


}
