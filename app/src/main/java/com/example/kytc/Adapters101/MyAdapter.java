package com.example.kytc.Adapters101;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kytc.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> names;

    public MyAdapter(Context context, ArrayList<Student> names) {
        this.context = context;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.names_item, null);

        TextView tv = v.findViewById(R.id.name_tv);
        TextView tv2 = v.findViewById(R.id.number_tv);

        Student s = names.get(i);

        tv.setText(s.getStudentName());
        tv2.setText(s.getStudentNumber());
        return v;
    }
}
