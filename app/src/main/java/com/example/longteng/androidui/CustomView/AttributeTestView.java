package com.example.longteng.androidui.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.longteng.androidui.R;

/**
 * Created by longteng on 2017/2/28.
 */

public class AttributeTestView extends View{
    private static final int[] mAttr = { R.attr.title};
    public AttributeTestView(Context context) {
        super(context);
    }

    public AttributeTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AttributeTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,mAttr);
        String title = typedArray.getString(0);
        Toast.makeText(context,title,Toast.LENGTH_LONG).show();
        Toast.makeText(context,String.valueOf(R.attr.title),Toast.LENGTH_LONG).show();
        int i =  R.attr.title;
    }
}
