package com.example.gaurav.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/13/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    Context context;
    ArrayList<Student> students;
    StudentAdapter(Context context,ArrayList<Student> students){
        this.context=context;
        this.students=students;
    }
    @Override
    public StudentAdapter.StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.list_item,parent,false);
        return (new StudentHolder(view));
    }

    @Override
    public void onBindViewHolder(StudentAdapter.StudentHolder holder, int position) {

        Student student=students.get(position);
        //holder.tvcourse.setText(student.getCourse());
        //holder.tvage.setText(String.valueOf(student.getAge()));
        holder.tvname.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
    static class StudentHolder extends RecyclerView.ViewHolder{

        TextView tvage;
        TextView tvname;
        TextView tvcourse;

        public StudentHolder(View itemView) {
            super(itemView);
            //tvage=(TextView) itemView.findViewById(R.id.tvage);
            tvname=(TextView) itemView.findViewById(R.id.tvname);
            //tvcourse=(TextView) itemView.findViewById(R.id.tvcourse);
        }
    }
}
