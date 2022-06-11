package com.example.kytc.Fragments101;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kytc.R;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        if (getArguments() != null) {
            Bundle b = getArguments();
            String name = b.getString("fragmentName");

            TextView tv = v.findViewById(R.id.fragment1Tv);
            tv.setText(name);
        }

        return v;

    }

}