package com.example.kytc.SharedPreferences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kytc.R;

import java.util.ArrayList;

public class PeopleAdatpter extends RecyclerView.Adapter<PeopleAdatpter.ViewHolder> {
    private ArrayList<String> people;
    private Context context;

    public PeopleAdatpter(ArrayList<String> people, Context context) {
        this.people = people;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.people_item,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name_tv.setText(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_tv =  itemView.findViewById(R.id.name_tv);
        }

    }
}
