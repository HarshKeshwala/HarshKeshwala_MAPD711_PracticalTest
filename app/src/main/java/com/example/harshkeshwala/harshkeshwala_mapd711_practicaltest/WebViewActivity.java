package com.example.harshkeshwala.harshkeshwala_mapd711_practicaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        webView = (WebView) findViewById(R.id.webviewActivity);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.dietitians.ca/Learn/BMI-Adult.aspx");
    }
}
