package com.example.longteng.androidui.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by longteng on 2017/2/24.
 */

public class TouchViewTest extends ImageView {
    public TouchViewTest(Context context) {
        super(context);
    }

    public TouchViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("touch_test","onTouchEvent "+event.getAction());
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("touch_test","dispatchTouchEvent "+event.getAction());
        return super.dispatchTouchEvent(event);
    }

}
