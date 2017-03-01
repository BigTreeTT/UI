package com.example.longteng.androidui.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

public class TestService extends Service {
    public static final String TAG = "TestService";
    private MyBinder mBinder = new MyBinder();
    private boolean stopFlag = true;
    private Timer timer;
    private Date firstTime = new Date();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Log.i(TAG,"timerTask run");
        }
    };


    public TestService() {
        Log.i(TAG,"construct");
        timer = new Timer();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");

        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        firstTime.setHours(12);
        firstTime.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        String t = dateFormat.format(firstTime);
        timer.schedule(task,firstTime,1000*60*60*24);
        Log.i(TAG,"onCreate "+"firstTime.getTime():"+t);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"onUnbind");
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }

    class MyBinder extends Binder{
        public void startDownload(){
            TestService.this.startDownload();
        }
        public void stopDownload(){
            TestService.this.stopDownload();
        }

    }
    public void startDownload(){
        stopFlag = false;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        if (stopFlag)
                            break;
                        sleep(1000);
                        Log.i(TAG,"downloading...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    public void stopDownload(){
        stopFlag = true;
    }
}
