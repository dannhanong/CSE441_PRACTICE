package com.ktpm1.btth03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.imgAvatar.setImageResource(student.getYear());
        holder.tvId.setText(student.getId());
        holder.tvFullName.setText(student.getFullName().getFirst() + " " + student.getFullName().getMidd() + " " + student.getFullName().getLast());
        holder.tvGpa.setText(String.valueOf(student.getGpa()));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvFullName, tvGpa;
        ImageView imgAvatar;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvId = itemView.findViewById(R.id.tvId);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvGpa = itemView.findViewById(R.id.tvGpa);
        }
    }
}
