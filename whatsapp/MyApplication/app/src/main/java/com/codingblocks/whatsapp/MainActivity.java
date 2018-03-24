package com.codingblocks.whatsapp;

import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
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
    TabsPagerAdapter pagerAdapter;
    ActionBar actionBar;
    ArrayList<String> tabs;
    FloatingActionButton floatButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message="Clicked";
        switch (item.getItemId())
        {
            case R.id.search_item:
                message = "Search";
                break;
            case R.id.new_group_item:
                message = "New Group";
                break;
            case R.id.new_broadcast_item:
                message="New Broadcst";
                break;
            case R.id.whatsapp_web_item:
                message="Whatsapp Web";
                break;
            case R.id.starred_message_item:
                message="Starred Messages";
                break;
            case R.id.settings_item:
                message="Settings";
                break;


        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        floatButton = (FloatingActionButton) findViewById(R.id.floatButton);
        actionBar = getSupportActionBar();
        pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        if(actionBar!=null)
            actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        tabs = new ArrayList<>();
        tabs.add("Chats");
        tabs.add("Status");
        tabs.add("Calls");
        for (String curr:tabs) {
            actionBar.addTab(actionBar.newTab().
                    setText(curr).setTabListener(MainActivity.this));
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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
        switch (tab.getPosition()){
            case 0:
                floatButton.setImageResource(R.drawable.message2);
                break;
            case 1:
                floatButton.setImageResource(R.drawable.status);
                break;
            case 2:
                floatButton.setImageResource(R.drawable.icon_phone);
                break;
       }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
