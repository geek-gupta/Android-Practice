package com.example.gaurav.facteria;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gaurav.facteria.SplashFragments.FirstSplashScreen;
import com.example.gaurav.facteria.SplashFragments.FourthSplashScreen;
import com.example.gaurav.facteria.SplashFragments.SecondSplashScreen;
import com.example.gaurav.facteria.SplashFragments.ThirdSplashScreen;

/**
 * Created by gaurav on 6/24/2017.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int id;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        id=position;
        switch (id){
            case 0:
                return new FirstSplashScreen();
            case 1:
                return new SecondSplashScreen();
            case 2:
                return new ThirdSplashScreen();
            case 3:
                return new FourthSplashScreen();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
