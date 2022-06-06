package com.example.kytc.Adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.kytc.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView students_lv;
    EditText name_et,id_et;
    Button add_student_bt,move_to_rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students_lv = findViewById(R.id.students_lv);
        name_et = findViewById(R.id.name_et);
        id_et = findViewById(R.id.id_et);
        add_student_bt = findViewById(R.id.add_student_bt);
        move_to_rv = findViewById(R.id.move_to_rv);

        ArrayList<Student> names = new ArrayList<>();
        names.add(new Student("ahmed","120201447"));
        names.add(new Student("omar","125478544"));
        names.add(new Student("anas","874951475"));
        names.add(new Student("ehsan","120120147"));


        MyAdapter adapter = new MyAdapter(names,this);
        students_lv.setAdapter(adapter);

        add_student_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_et.getText().toString();
                String id = id_et.getText().toString();
                names.add(new Student(name,id));
                adapter.notifyDataSetChanged();
            }
        });
        students_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                names.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
        move_to_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RecyclerActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", names);
                intent.putExtra("students",args);
                startActivity(intent);
            }
        });

    }
}