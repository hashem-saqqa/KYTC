package com.example.kytc.Adapters101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kytc.R;

import java.util.ArrayList;

public class ListViewActivity101 extends AppCompatActivity {
    ListView names_lv;
    EditText name_et ;
    Button add_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view101);

         names_lv = findViewById(R.id.names_lv);
         name_et = findViewById(R.id.name_et);
         add_bt = findViewById(R.id.add_bt);

        ArrayList<Student> names = new ArrayList<>();
        names.add(new Student("ahmed","120201478"));
        names.add(new Student("morad","152147521"));
        names.add(new Student("omar","12015755"));
        names.add(new Student("anas","857145554"));

        MyAdapter myAdapter = new MyAdapter(ListViewActivity101.this,names);

        names_lv.setAdapter(myAdapter);

        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_et.getText().toString();
//                names.add(name);
                myAdapter.notifyDataSetChanged();
            }
        });
        names_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                names.remove(i);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

}