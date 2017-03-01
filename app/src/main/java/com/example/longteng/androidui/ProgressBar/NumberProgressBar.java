package com.example.longteng.androidui.ProgressBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by longteng on 2017/2/5.
 */

public class NumberProgressBar extends ProgressBar {
    Paint mPaint = null;
    /**
     * Create a new progress bar with range 0...100 and initial progress of 0.
     *
     * @param context the application environment
     */
    public NumberProgressBar(Context context) {
        super(context);
        init();
    }

    public NumberProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumberProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }
    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setAntiAlias(true);
        setIndeterminate(false);

    }


    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        setProgress(80);
        int width = getWidth();
        int height = getHeight();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int radius = Math.min(width - paddingLeft -paddingRight,height - paddingTop -paddingBottom)/2;
        int x = (width - paddingLeft - paddingRight)/2+paddingLeft;
        int y = (height - paddingBottom - paddingTop)/2+paddingTop;
        canvas.drawCircle(x,y,radius,mPaint);
        int progress = getProgress();
        int max = getMax();
        Log.i("onDraw","max:"+max+" progress:"+progress);
        float sweepAngle = 360 * (((float)progress)/max);
        mPaint.setColor(Color.RED);
        RectF oval = new RectF(paddingLeft,paddingTop,paddingLeft + radius*2,paddingTop + radius*2);
        Log.i("onDraw","sweepAngle="+sweepAngle);
        canvas.drawArc(oval,0,sweepAngle,true,mPaint);
    }
}
