package com.example.longteng.androidui.Service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.longteng.androidui.R;

public class ServiceActivity extends AppCompatActivity {
    public static final String TAG = "TestService";
    private MyServiceConnection connection = new MyServiceConnection();
    TestService.MyBinder mBinder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }
    public void onClickStart(View view){
        Intent intent = new Intent(this,TestService.class);
        startService(intent);
    }
    public void onClickBind(View view){
        Intent intent = new Intent(this,TestService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }
    public void onClickUnbind(View view){
        unbindService(connection);

    }
    public void onClickStop(View view){
        Intent intent = new Intent(this,TestService.class);
        stopService(intent);

    }
    public void onClickStartDownload(View view){
        if (mBinder == null)
            return;
        mBinder.startDownload();
    }
    public void onClickStopDownload(View view){
        if (mBinder == null)
            return;
        mBinder.stopDownload();
    }
    class MyServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG,"onServiceConnected");
            mBinder = (TestService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG,"onServiceDisconnected");

        }
    }
}
