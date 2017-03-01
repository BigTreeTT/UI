package com.example.longteng.androidui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener{
    private WebView mWebView;
    private String mLoadUrl = "http://blog.csdn.net/harvic880925";
    private String baidu = "http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        init();

    }
    private void init(){
        mWebView = (WebView) findViewById(R.id.webView);
        findViewById(R.id.load).setOnClickListener(this);
        findViewById(R.id.goBack).setOnClickListener(this);
        findViewById(R.id.home).setOnClickListener(this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.load){
            //mLoadUrl = mEditText.getText().toString();
            mWebView.loadUrl(baidu);
        }else if (v.getId() == R.id.goBack){
            mWebView.goBack();
        }else if (v.getId() == R.id.home){
            WebBackForwardList historyList =  mWebView.copyBackForwardList();
            int steps = historyList.getCurrentIndex();
            mWebView.goBackOrForward(-steps);
        }
    }
}
