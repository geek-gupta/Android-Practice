package com.example.gaurav.vision;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.gaurav.vision.Fragment.ViewpagerAdapter;

public class SplashScreen extends AppCompatActivity {

    ViewPager viewPager;
    Intent intent;
    String filename = "MY_PREF";
    String KEY = "showsplash";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        sharedPreferences = getSharedPreferences(filename, MODE_PRIVATE);
        boolean showSplashScreen = sharedPreferences.getBoolean(KEY, true);
        if (showSplashScreen) {
            sharedPreferences.edit().putBoolean(KEY, false).commit();
            viewPager = (ViewPager) findViewById(R.id.view_pager);
            ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);
            Snackbar snackbar = Snackbar
                    .make(viewPager, "Welcome to Vision." +
                            "Swipe Left", Snackbar.LENGTH_LONG);

            snackbar.show();
            //Toast.makeText(SplashScreen.this, "-->  Swipe Left  -->", Toast.LENGTH_LONG).show();


            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    if (position == viewPager.getAdapter().getCount() - 1) {
                        startMyActivity();
                    }

                }

                @Override
                public void onPageSelected(int position) {

                }


                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        } else {
            startMyActivity();
        }
    }

    private void startMyActivity() {
        intent = new Intent(SplashScreen.this, MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}
