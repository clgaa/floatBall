package com.example.chenlong.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chenlong on 6/4/16.
 */
public class SencondActivity extends Activity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setType(WindowManager.LayoutParams.TYPE_PHONE);
//        WindowManager mWindowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
//        mWindowManager.
        mTextView = (TextView) findViewById(R.id.text);
        mTextView.setText("sencondActivity");
        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
    }
}
