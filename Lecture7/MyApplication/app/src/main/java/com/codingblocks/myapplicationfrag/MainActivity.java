package com.codingblocks.myapplicationfrag;

import android.content.Context;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnRed;
    Button btnBlue;
    Button btnShow;
    FrameLayout frame;
    FragmentManager fm;
    FragmentTransaction ft;
    BlueFragment rf;
    RedFragment redFragmentObject;
    LinearLayout hiddenll;
    int fragId;
    String KEY="FRAGKEY";

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY,fragId);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnBlue = (Button) findViewById(R.id.btnblue);
        btnRed = (Button) findViewById(R.id.btnRed);
        frame = (FrameLayout) findViewById(R.id.frame);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        btnShow = (Button) findViewById(R.id.btnShow);
        hiddenll = (LinearLayout) findViewById(R.id.hiddenll);
//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (hiddenll.getVisibility() == View.VISIBLE) {
//                    hiddenll.setVisibility(View.GONE);
//                } else if (hiddenll.getVisibility() == View.GONE
//                        || hiddenll.getVisibility() == View.INVISIBLE
//                        ) {
//                    hiddenll.setVisibility(View.VISIBLE);
//                }
//                overridePendingTransition(R.anim.anim_slide_in_slow, R.anim.slide_out_slow);
//            }
//        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(0);
            }
        });
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(1);
            }
        });
        setFragment(savedInstanceState==null?0:savedInstanceState.getInt(KEY));
    }

    void setFragment(int id) {
        fragId =id;
        if (id == 0)
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.frame, new BlueFragment()).
                    commit();
        else
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.frame, new RedFragment()).
                    commit();
    }

    public static void showMessage(Context context) {
        Toast.makeText(context, "From main", Toast.LENGTH_SHORT).show();
    }

    public void showMessage() {
        Toast.makeText(this, "From main", Toast.LENGTH_SHORT).show();
    }

    public void changeVal(int val) {
//        int currentVal= Integer.valueOf(tvResult.getText().toString());
//
//        tvResult.setText(String.valueOf(currentVal + val));

        ((ResultFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragment_result)).changeVal(val);

    }
}
