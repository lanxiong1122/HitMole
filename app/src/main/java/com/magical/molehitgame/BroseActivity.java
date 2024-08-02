package com.magical.molehitgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BroseActivity extends AppCompatActivity {

    private TextView textView;
    public static String page = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brose);
        textView=(TextView) findViewById(R.id.textView);
        //mywebView.setWebViewClient(new WebViewClient());
        //mywebView.setWebViewClient(new mywebClient());
        //mywebView.loadUrl(page.equals("1")?"https://www.freeprivacypolicy.com/live/19a4c967-a544-497d-b389-5455557bcaa4":"file:///android_asset/us.txt");
        //WebSettings webSettings=mywebView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        lookText();
    }


        protected void lookText() {

            // 从assets文件夹读取文件
            try {
                InputStream inputStream = getAssets().open(page.equals("1")?"pra.txt":"us.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }

                reader.close();
                inputStream.close();

                // 设置文本到TextView
                textView.setText(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    /*public class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }*/
   /* @Override
    public void onBackPressed() {
        if (mywebView.canGoBack()) {
            mywebView.goBack();
        } else {
            super.onBackPressed();
        }
    }*/

}