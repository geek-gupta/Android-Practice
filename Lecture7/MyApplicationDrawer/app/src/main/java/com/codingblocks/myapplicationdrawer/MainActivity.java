package com.codingblocks.myapplicationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    FrameLayout frame;
    ListView lv;
    ArrayList<String> list;
    DrawerLayout mydrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        mydrawer = (DrawerLayout) findViewById(R.id.mydrawer);

        lv = (ListView) findViewById(R.id.left_drawer);
        Myadapter adapter = new Myadapter();
        lv.setAdapter(adapter);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.data_frame, new MyFragment()).commit();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle args = new Bundle();
                args.putInt("id", position);
                MyFragment dataFrag = new MyFragment();
                dataFrag.setArguments(args);
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.data_frame, dataFrag).
                        commit();
                lv.setItemChecked(position, true);
                setTitle(String.valueOf("DRAWER AT " + position));
                mydrawer.closeDrawer(lv);
            }
        });
    }

    public void opendrawer() {
        mydrawer.openDrawer(Gravity.START);
        mydrawer.openDrawer(Gravity.END);
    }

    public void closedrawer() {
        mydrawer.closeDrawer(Gravity.START);
    }

    class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater li = ((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE));
            View rowView = li.inflate(R.layout.drawerlistitem, parent, false);
            ((TextView) rowView.findViewById(R.id.rowText)).setText(getItem(position));

            return rowView;
        }
    }
}
