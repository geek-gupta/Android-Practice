package com.music.gaurav.gmusic;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {


    ViewPager viewPager;
    TabsPagerAdapter tabsPagerAdapter;
    ActionBar actionBar;
    ArrayList<String> tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        actionBar = getSupportActionBar();
        tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsPagerAdapter);
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        tabs = new ArrayList<>();
        tabs.add("Songs");
        tabs.add("Albums");
        tabs.add("Artists");
        for (String curr : tabs) {
            actionBar.addTab(actionBar.newTab().setText(curr).setTabListener((ActionBar.TabListener) MainActivity.this));
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message = "";
        switch (item.getItemId()) {
            case R.id.search_bar:
                message = "Search";
                break;
            case R.id.shuffle_all:
                message = "Shuffle All";
                break;
            case R.id.play_list:
                message = "playList";
                break;
            case R.id.rate_us:
                message = "Rate Us";
                break;
            case R.id.feedback:
                message = "FeedBack";
                break;
            case R.id.settings:
                message = "settings";
                break;
            case R.id.music_video:
                message = "Music Video";
                break;
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
