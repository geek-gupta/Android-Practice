package com.example.gaurav.hypemessanger.OverlayManager;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaurav.hypemessanger.CommonUtils.Constants;
import com.example.gaurav.hypemessanger.R;

public class DataOverlayManagerService extends Service {
    String message;
    TextView txtmsg;
    private WindowManager windowManager;
    private ImageView floatingBubble;
    View activityView;
    public DataOverlayManagerService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            message = intent.getStringExtra(Constants.DATA_KEY);
        }catch (Exception e){

        }

        txtmsg = (TextView)activityView.findViewById(R.id.textmsg);
        txtmsg.setText(message);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        floatingBubble =new ImageView(this);
        floatingBubble.setImageResource(R.mipmap.ic_launcher_round);
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        final WindowManager.LayoutParams myParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        myParams.gravity = Gravity.TOP | Gravity.LEFT;
        myParams.x = 0;
        myParams.y = 0;
        LayoutInflater inflater = LayoutInflater.from(this);
        activityView = inflater.inflate(R.layout.overlay_layout_msgs, null);
        windowManager.addView(activityView,myParams);
        try{
            activityView.setOnTouchListener(new View.OnTouchListener() {
                WindowManager.LayoutParams paramsT = myParams;
                private int  initialX;
                private  int initialY;
                private float initialTouchX;
                private float initialTouchY;
                private  long touchStartTime = 0;

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(System.currentTimeMillis() - touchStartTime < ViewConfiguration.getLongPressTimeout()
                            && initialX == event.getX()){
                        windowManager.removeViewImmediate(v);
                        stopSelf();
                        return false;
                    }


                    switch (event.getAction()){
                        case MotionEvent.ACTION_UP:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            paramsT.x = initialX + (int)(event.getRawX() - initialTouchX);
                            paramsT.y = initialY + (int)(event.getRawY() - initialTouchY);
                            windowManager.updateViewLayout(v,paramsT);
                            break;
                    }
                    return false;
                }
            });
        }catch (Exception e){
            Toast.makeText(this, "Exception", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
