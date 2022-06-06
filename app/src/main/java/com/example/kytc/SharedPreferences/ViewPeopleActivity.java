package com.example.kytc.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.kytc.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ViewPeopleActivity extends AppCompatActivity {
    RecyclerView people_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_people);

        people_rv = findViewById(R.id.people_rv);

        SharedPreferences preferences = getSharedPreferences("myFile", MODE_PRIVATE);
        Set<String> tmp = new HashSet<>();
        tmp.add("Ahmed");

        Set<String> names = preferences.getStringSet("peopleNames", tmp);
        ArrayList<String> namesArrayList = new ArrayList<>();
        namesArrayList.addAll(names);

        PeopleAdatpter peopleAdatpter = new PeopleAdatpter(namesArrayList, ViewPeopleActivity.this);

        people_rv.setAdapter(peopleAdatpter);

        people_rv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));



    }
}