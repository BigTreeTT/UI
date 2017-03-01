package com.example.longteng.androidui.CustomView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.longteng.androidui.R;

public class CustomViewShowActivity extends AppCompatActivity {
    private ImageView ivTouch ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_show);
        init();
    }
    private void init(){
        ivTouch = (ImageView) findViewById(R.id.iv_touch);
        ivTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("touch_test","onTouch "+event.getAction());
                return false;
            }
        });
    }
}
