package com.example.gaurav.services;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by gaurav on 6/22/2017.
 */

public class MyAsyncTask extends AsyncTask<Integer, Void ,String> {
    String TAG="InAsyncTask";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Integer... params) {
        Log.e(TAG, "doInBackground: ");
        int time=5;
        if(params.length>0)
            time=params[0];
        printTimeLog(10);
        return "";
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }
    void printTimeLog(int duration){
        for(int i=0;i<duration && MainActivity.stop!=false ;i++){

                loopOneSecond();
                Log.w(TAG, "PrintTimeLog:" + i);

        }
    }
    void loopOneSecond(){
        long currentTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - currentTime < 1000){
        }
    }
}
