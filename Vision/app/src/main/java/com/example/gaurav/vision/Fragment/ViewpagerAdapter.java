package com.example.gaurav.vision.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by gaurav on 7/9/2017.
 */

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        int id = position;
       switch (id){
           case 0:
               return new Page_one_Fragment(position);
           case 1:
               return new Page_two_Fragment(position);
           case 2:
               return new Page_three_Fragment(position);
           case 3:
               return new Page_four_Fragment(position);
       }

       return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
