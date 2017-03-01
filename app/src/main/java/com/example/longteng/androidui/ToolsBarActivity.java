package com.example.longteng.androidui;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ToolsBarActivity extends AppCompatActivity {
    TextView tv0;
    TextView tv1;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_bar);
        tv0 = (TextView) findViewById(R.id.textView0);
        tv1 = (TextView) findViewById(R.id.textView1);
        toolbar = (Toolbar) findViewById(R.id.toolsBar);
        setStatusBarWithStyle1();
    }

    /**
     * Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
     * @return
     */
    public boolean setStatusBarWithStyle1(){
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View topView = new View(this);
            ViewGroup mContentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
            View mChildView = mContentView.getChildAt(0);
            if (mChildView != null) {
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
                mChildView.setFitsSystemWindows(true);
            }
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,getStatusBarHeight());
            lp.gravity = Gravity.TOP;
            topView.setLayoutParams(lp);
            topView.setBackgroundColor(Color.YELLOW);
            ViewGroup decorView = (ViewGroup) window.getDecorView();
            decorView.addView(topView);


        }
        return false;
    }
    public boolean setStatusBarWithStyle2(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(Color.RED);
            return true;
        }
        return false;
    }
    public boolean setStatusBarWisthStyle3(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(Color.RED);
            View decor = window.getDecorView();
            int ui = decor.getSystemUiVisibility();
            if (true) {
                ui |=View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            //<item name="android:windowLightStatusBar">true</item>
            //系统状态的那些文字图标就会变成黑色
            decor.setSystemUiVisibility(ui);
            return true;

        }
        return false;
    }
    public int getStatusBarHeight(){
        try {
            Class<?> class1 = Class.forName("com.android.internal.R$dimen");
            Object obj = class1.newInstance();
            Field field = class1.getField("status_bar_height");
            int y = Integer.parseInt(field.get(obj).toString());
            Log.i("lt_status","y "+y);
            tv0.setText("y:"+y);//id
            int statusBar = getResources().getDimensionPixelSize(y);
            Log.i("lt_status","statusBar "+statusBar);
            tv1.setText("status:"+statusBar);
            return statusBar;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
