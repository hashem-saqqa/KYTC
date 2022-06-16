package com.example.kytc.DataTrans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kytc.R;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity implements onButtonPressed {
    Button testBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        testBt = findViewById(R.id.testBt);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, new BlankFragment()).commit();
        testBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BlankFragment b = BlankFragment.newInstance("changed");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, b).commit();
            }
        });
    }

    @Override
    public void onPressed(String buttonName) {
        testBt.setText(buttonName);
    }
}