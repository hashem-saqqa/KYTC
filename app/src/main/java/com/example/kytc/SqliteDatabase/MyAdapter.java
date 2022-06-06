package com.example.kytc.SqliteDatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kytc.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {
    Context context;
    ArrayList<Car> cars;

    public MyAdapter(Context context, ArrayList<Car> cars) {
        this.context = context;
        this.cars = cars;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cars_item,parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.carName.setText(cars.get(position).getName());
        holder.carColor.setText(cars.get(position).getColor());
        holder.carYear.setText(cars.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView carName;
        TextView carColor;
        TextView carYear;

        public Viewholder( View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.nameTv);
            carColor = itemView.findViewById(R.id.colorTv);
            carYear = itemView.findViewById(R.id.yearTv);
        }
    }
}
