package com.example.longteng.androidui;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.longteng.androidui.CustomView.CustomViewShowActivity;
import com.example.longteng.androidui.Notification.NotificationActivity;
import com.example.longteng.androidui.ProgressBar.ProgressBarActivity;
import com.example.longteng.androidui.Service.ServiceActivity;
import com.example.longteng.androidui.security.SecurityActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.showDialog) {
            showDialog();
        } else if (view.getId() == R.id.toolsBar) {
            toToolsBarActivity();
        } else if (view.getId() == R.id.toTextActivity) {
            toTextViewActivity();
        } else if (view.getId() == R.id.toWebView) {
            toWebViewActivity();
        } else if (view.getId() == R.id.toAnimation) {
            toAnimationActivity();
        } else if (view.getId() == R.id.toProgressBar) {
            toProgressBarActivity();
        } else if (view.getId() == R.id.toService) {
            toServiceActivity();
        } else if (view.getId() == R.id.btn_to_security) {
            toSecurityActivity();
        } else if (view.getId() == R.id.btn_to_notification) {
            toNotificationActivity();
        } else if (view.getId() == R.id.btn_to_custom) {
            toCustomViewActivity();
        }

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder.create();
        // 用Window类来设置对话框的布局文件
        Window win = dialog.getWindow();
        win.setWindowAnimations(R.style.dialogWindowAnim);
        dialog.show();
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_layout, null, false);
        win.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

    }

    private void toToolsBarActivity() {
        Intent intent = new Intent(this, ToolsBarActivity.class);
        startActivity(intent);

    }

    private void toTextViewActivity() {
        Intent intent = new Intent(this, TextViewActivity.class);
        startActivity(intent);
    }

    private void toWebViewActivity() {
        Intent intent = new Intent(this, WebViewActivity.class);
        startActivity(intent);
    }

    private void toAnimationActivity() {
        Intent intent = new Intent(this, AnimationActivity.class);
        startActivity(intent);
    }

    private void toProgressBarActivity() {
        Intent intent = new Intent(this, ProgressBarActivity.class);
        startActivity(intent);
    }

    private void toServiceActivity() {
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);
    }

    private void toSecurityActivity() {
        Intent intent = new Intent(this, SecurityActivity.class);
        startActivity(intent);
    }

    private void toNotificationActivity() {
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }

    private void toCustomViewActivity() {
        Intent intent = new Intent(this, CustomViewShowActivity.class);
        startActivity(intent);
    }


}
