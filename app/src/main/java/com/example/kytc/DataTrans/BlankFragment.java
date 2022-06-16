package com.example.kytc.DataTrans;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kytc.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    onButtonPressed pressed;

    private String mParam1;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String param1) {

        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pressed = (onButtonPressed) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v =  inflater.inflate(R.layout.fragment_blank, container, false);
        Button bu = v.findViewById(R.id.changeBt);
        if (mParam1 != null)
        bu.setText(mParam1);

       bu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
//              Button buu = getActivity().findViewById(R.id.testBt);
//              buu.setText("Changed");
               pressed.onPressed("changed");
           }
       });

        return v;
    }
}