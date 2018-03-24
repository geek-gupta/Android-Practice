package com.codingblocks.whatsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codingblocks.whatsapp.Chats.ChatFragment;
import com.codingblocks.whatsapp.Status.StatusFragment;
import com.codingblocks.whatsapp.calls.CallsFragment;

/**
 * Created by Nipun on 6/23/17.
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
