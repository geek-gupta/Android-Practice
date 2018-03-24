package com.example.gaurav.revise_listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/13/2017.
 */

public class StudentAdapter extends BaseAdapter{

    Context context;
    ArrayList<Student> studentsList;

    public StudentAdapter(Context context,ArrayList<Student> studentsList){
        this.context=context;
        this.studentsList=studentsList;
    }

    @Override
    public int getCount() {
        return studentsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(getItem(position).course.equals("pandora"))
            return 0;
        else
            return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Student getItem(int position) {
        return studentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("CovertView",String.valueOf(convertView));
        long time= System.currentTimeMillis();

        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.list_item,parent,false);

            if(getItemViewType(position)==0){
                convertView = inflater.inflate(R.layout.list_item,parent,false);
            }
            else
                convertView = inflater.inflate(R.layout.list_item_2,parent,false);
        }

        Student currentStudent=getItem(position);
        TextView tvname=(TextView) convertView.findViewById(R.id.tvname);
        TextView tvage = (TextView) convertView.findViewById(R.id.tvage);
        TextView tvcourse = (TextView) convertView.findViewById(R.id.tvcourse);

        tvname.setText(String.valueOf(currentStudent.getName()));
        tvage.setText(String.valueOf(currentStudent.getAge()));
        tvcourse.setText(String.valueOf(currentStudent.getCourse()));
        long time2=System.currentTimeMillis();
        Log.d("ListView","Total time for"+position+"="+(time2-time));

        return convertView;
    }
}
