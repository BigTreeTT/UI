package com.example.longteng.androidui.CustomView;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.longteng.androidui.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by longteng on 2017/2/23.
 */

public class VDHLLayout extends LinearLayout {
    private ViewDragHelper mDragHelper;
    private View tv;
    private View tvEdge;


    public VDHLLayout(Context context) {
        super(context);
        init();
    }

    public VDHLLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VDHLLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDragHelper = ViewDragHelper.create(this, 1.0f, new DragCallBack());
        mDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return mDragHelper.shouldInterceptTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        /**
         * 在自定义的layout内部使用child直接使用getChildAt(i)的方式获取引用；
         */
        tv = getChildAt(0);
        tvEdge = getChildAt(1);
    }

    class DragCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            int leftBound = getPaddingLeft();
            int rightBound = getWidth() - child.getWidth() - getPaddingRight();
            int newLeft = Math.max(leftBound, Math.min(rightBound, left));
            return newLeft;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            int topBound = getPaddingTop();
            int bottomBound = getHeight() - child.getHeight() - getPaddingBottom();
            int newTop = Math.max(topBound, Math.min(bottomBound, top));
            return newTop;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (releasedChild == tv){
                mDragHelper.settleCapturedViewAt(30, 40);
                invalidate();
            }
        }

        /**
         * 边界拖动时回掉
         * @param edgeFlags
         * @param pointerId
         */

        @Override
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            if (tvEdge!=null){
                mDragHelper.captureChildView(tvEdge, pointerId);
            }
        }

        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
        }

        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {

        }

        @Override
        public void onEdgeTouched(int edgeFlags, int pointerId) {
            super.onEdgeTouched(edgeFlags, pointerId);
        }

        @Override
        public boolean onEdgeLock(int edgeFlags) {
            return super.onEdgeLock(edgeFlags);
        }

        @Override
        public int getOrderedChildIndex(int index) {
            return super.getOrderedChildIndex(index);
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return super.getViewHorizontalDragRange(child);
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return super.getViewVerticalDragRange(child);
        }

    }
}
