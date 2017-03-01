package com.example.longteng.androidui.CustomView;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Scroller;

import java.util.ArrayList;

/**
 * Created by longteng on 2017/2/23.
 */

public class ScrollView extends ViewGroup {
    private Scroller mScroller;
    private int hideViewWidth = 0;
    public ScrollView(Context context) {
        super(context,null);
        init(context);

    }

    public ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
        init(context);
    }

    public ScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        if (widthMeasureMode == MeasureSpec.EXACTLY) {
            width = sizeWidth;
        } else {

            if (getChildCount() != 0) {
                width = getChildAt(0).getMeasuredWidth();
            }

        }
        if (getChildCount() >= 1) {
            hideViewWidth = 0;
            for (int i = 1; i < getChildCount(); i++) {
                hideViewWidth += getChildAt(i).getWidth();
            }
        }
        if (heightMeasureMode == MeasureSpec.EXACTLY) {
            height = sizeHeight;
        } else {
            for (int i = 0; i < getChildCount(); i++) {
                height = Math.max(height, getChildAt(i).getMeasuredHeight());
            }
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = l;
        int childTop = t;
        int childRight = l;
        int childBottom = t;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();
            childBottom = childTop + childHeight;
            childRight = childLeft + childWidth;


            childView.layout(childLeft, childTop, childRight, childBottom);
            childLeft = childRight;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGesture.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_UP){
            int currentScrollX = getScrollX();
            Log.i("scroll","currentScrollX:"+currentScrollX);
            if (currentScrollX>=hideViewWidth/3){
                mScroller.startScroll(getScrollX(),0,hideViewWidth-currentScrollX,0);
            }else {
                mScroller.startScroll(getScrollX(),0,-currentScrollX,0);
            }
            invalidate();
        }

        return true;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(),0);
            invalidate();
        }

    }
    private GestureDetector mGesture = new GestureDetector(new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            int newScrollX = (int) (getScrollX() +distanceX);;
            if (newScrollX <= hideViewWidth && newScrollX >= 0) {
                scrollBy((int) distanceX,0);
            }else {
                if (distanceX>0){
                    distanceX = hideViewWidth - getScrollX();
                }else if (distanceX<0){
                    distanceX = -getScrollX();
                }
                scrollBy((int) distanceX,0);
            }


            return true;
        }


    });


}
