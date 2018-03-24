package com.example.gaurav.whatsapp;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ViewPager viewPager;
    TabsPagerAdapter pagerAdapter;
    ActionBar actionBar;
    ArrayList<String> tabs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        actionBar = getSupportActionBar();
        pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        tabs = new ArrayList<>();
        tabs.add("Chats");
        tabs.add("Status");
        tabs.add("Calls");
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
            case R.id.new_broadcast:
                message = "Broadcast";
                break;
            case R.id.new_group:
                message = "Group";
                break;
            case R.id.settings:
                message = "Settings";
                break;
            case R.id.whatsapp_web:
                message = "Whatsapp_Web";
                break;
            case R.id.starred_message:
                message = "Starred_message";
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
