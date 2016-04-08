package com.example.chenlong.test1;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by chenlong on 8/4/16.
 */
public class TopFloatService extends Service implements View.OnClickListener, View.OnKeyListener{

    private View ballView;
    private Button floatImage;
    private float x;
    private float y;
    private float mTouchStartX;
    private float mTouchStartY;
    private boolean isMoving = false;
    private WindowManager.LayoutParams ballParams;
    WindowManager wm;
    @Override
    public void onCreate() {
        super.onCreate();
        ballView = LayoutInflater.from(this).inflate(R.layout.floatball, null);
        floatImage = (Button) ballView.findViewById(R.id.float_image);
        creatView();
    }

    private void creatView() {
        wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        ballParams = new WindowManager.LayoutParams();
        ballParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        ballParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        ballParams.gravity = Gravity.LEFT | Gravity.TOP;
        ballParams.x = 0;
        ballParams.y = 0;
        ballParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        ballParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        ballParams.format = PixelFormat.RGBA_8888;
        wm.addView(ballView, ballParams);

        floatImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isMoving = false;
                        mTouchStartX = (int) event.getX();
                        mTouchStartY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        isMoving = true;
                        updateViewPosition();
                        break;
                    case MotionEvent.ACTION_UP:
                        mTouchStartX = mTouchStartY = 0;
                        break;
                }

                return isMoving;
            }
        });
    }


    private void updateViewPosition(){
        ballParams.x = (int)(x - mTouchStartX);
        ballParams.y = (int)(y - mTouchStartY);
        wm.updateViewLayout(ballView, ballParams);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}
