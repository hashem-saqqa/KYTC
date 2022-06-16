package com.example.kytc.FragmentDialog101;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kytc.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "myTag";
    Button showBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        showBt = findViewById(R.id.showBt);
        MyDialog  dialog = new MyDialog();


        showBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show(getSupportFragmentManager(),"");
            }
        });

    }
}