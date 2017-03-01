package com.example.longteng.androidui.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by longteng on 2017/2/27.
 */

public class TouchViewGroupTest extends LinearLayout {
    public TouchViewGroupTest(Context context) {
        super(context);
    }

    public TouchViewGroupTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewGroupTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("touch_test","group dispatchTouchEvent "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("touch_test","group onInterceptTouchEvent "+ev.getAction());
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i("touch_test","group onTouchEvent "+ev.getAction());
        return false;
    }
}
