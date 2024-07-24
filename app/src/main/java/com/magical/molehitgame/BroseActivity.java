package com.magical.molehitgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BroseActivity extends AppCompatActivity {

    private WebView mywebView;
    public static String page = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brose);
        mywebView=(WebView) findViewById(R.id.webview);
        //mywebView.setWebViewClient(new WebViewClient());
        mywebView.setWebViewClient(new mywebClient());
        mywebView.loadUrl(page.equals("1")?"https://www.freeprivacypolicy.com/live/19a4c967-a544-497d-b389-5455557bcaa4":"file:///android_asset/us.html");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }






    public class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        if (mywebView.canGoBack()) {
            mywebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}