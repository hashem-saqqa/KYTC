package com.example.kytc.ThirdProject;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kytc.R;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    ArrayList<Course> courses;
    Context context;


    public CourseAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.third_project_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        ThirdProjectDatabase db = new ThirdProjectDatabase(context);

        int id = courses.get(position).getId();
        String name = courses.get(position).getName();
        int hours = courses.get(position).getHours();
        int semester = courses.get(position).getSemester();

        holder.courseNameTv.setText(name);
        holder.courseHoursTv.setText("" + hours);
        holder.courseSemesterTv.setText("" + semester);

        holder.editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditCourseActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("hours", hours);
                intent.putExtra("semester", semester);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
        holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteCourse(id);
                courses = (ArrayList<Course>) db.getAllCourses();
//                notifyItemRemoved(position);
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void refreshData(ArrayList<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
//        notifyItemChanged(0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTv, courseHoursTv, courseSemesterTv;
        ImageView deleteIcon, editIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTv = itemView.findViewById(R.id.courseNameTv);
            courseHoursTv = itemView.findViewById(R.id.courseHoursTv);
            courseSemesterTv = itemView.findViewById(R.id.courseSemesterTv);
            deleteIcon = itemView.findViewById(R.id.delete_icon);
            editIcon = itemView.findViewById(R.id.edit_icon);
        }
    }

}
