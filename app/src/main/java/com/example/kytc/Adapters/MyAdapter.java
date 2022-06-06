package com.example.kytc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kytc.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<Student> names;
    Context context;

    public MyAdapter(ArrayList<Student> names, Context context) {
        this.names = names;
        this.context = context;
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
        View v = LayoutInflater.from(context).inflate(R.layout.my_item,null);

        TextView name_tv =  v.findViewById(R.id.name_tv);
        TextView id_tv = v.findViewById(R.id.id_tv);

        name_tv.setText(names.get(i).getName());
        id_tv.setText(names.get(i).getId());

        return v;
    }
}
