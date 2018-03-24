package com.example.gaurav.whatsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gaurav.whatsapp.chats.ChatFragment;

/**
 * Created by gaurav on 6/23/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment currFragment = null;
        switch (position) {
            case 0:
                currFragment = new ChatFragment();
                break;
            case 1:
                currFragment = new StatusFragment();
                break;
            case 2:
                currFragment = new CallsFragment();
                break;
        }
        return currFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
