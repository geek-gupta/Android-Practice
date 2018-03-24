package com.codingblocks.myapplicationviewpager;

import android.animation.LayoutTransition;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    int curr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        final MyPagerAdapter adapter =
                new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        Button previous = (Button) findViewById(R.id.previous);
        pager.setPageTransformer(true,new mytransformer());
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = pager.getCurrentItem();
                if (curr > 0)
                    pager.setCurrentItem(curr - 1,true);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = pager.getCurrentItem();
                if (curr < 4)
                    pager.setCurrentItem(curr + 1);
            }
        });
    }
    class mytransformer implements ViewPager.PageTransformer{

        @Override
        public void transformPage(View page, float position) {
           // overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            page.setScaleX(4);
        }
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle args=new Bundle();
            args.putInt("id",position);
            if (position % 2 == 0)
            {
                PageFragment pf=new PageFragment();
                pf.setArguments(args);

                return pf;
            }
            else
                return new Fragment2();
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
