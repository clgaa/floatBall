package com.example.chenlong.test1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by chenlong on 6/4/16.
 */
public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.text)).setText("ThirdActivity");
    }
}
