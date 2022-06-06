package com.example.kytc.Sharedpreferences101;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kytc.R;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolderr> {
    Context context;
    ArrayList<String> names;

    public RvAdapter(Context context, ArrayList<String> names) {
        this.context = context;
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent,
                                          int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.rv_item,
               parent,false);
        return new ViewHolderr(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderr holder, int position) {
        String name = names.get(position);
        holder.name_tv.setText(name);

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolderr extends RecyclerView.ViewHolder {
        TextView name_tv;

        public ViewHolderr(@NonNull View itemView) {
            super(itemView);
            name_tv = itemView.findViewById(R.id.name_tv);
        }
    }
}
