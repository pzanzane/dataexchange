package com.dataexchange.dataexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    //https://dev.dataexchange.io
    private static final String URL = "https://dev.dataexchange.io";
    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(client);
        webView.loadUrl(URL);
    }

    private WebViewClient client = new WebViewClient(){

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            Log.d("WASTE","In Webviewclient");
            String url = request.getUrl()!=null?request.getUrl().toString():null;
            if(url == null){
                return  true;
            }

            Log.d("WASTE","shouldOverrideUrlLoading: "+url);
            view.loadUrl(url);
            return false;
        }
    };
}
