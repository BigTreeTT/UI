package com.example.longteng.androidui.security;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.longteng.androidui.R;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
    }
    public void messageDigest(View view){
        String str="123";
        try {
            byte[] plainText=str.getBytes("UTF8");
            MessageDigest messageDigest= MessageDigest.getInstance("SHA-1");
            messageDigest.update(plainText);
            byte[] digest = null;
            digest = messageDigest.digest();
            String string = new String(digest,"UTF-8");
            Log.i("security", string);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
