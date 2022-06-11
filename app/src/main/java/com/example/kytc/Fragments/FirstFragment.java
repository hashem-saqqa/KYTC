package com.example.kytc.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kytc.R;

public class FirstFragment extends Fragment {

    public FirstFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        Bundle b = getArguments();
       String s = b.getString("fragmentName");
        TextView tv =  v.findViewById(R.id.fragmentText);
        tv.setText(s);
        return v;

    }
}