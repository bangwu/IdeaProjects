package net.learn2deve.Intents;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.speech.RecognitionService.*;

/**
 * Created by twer on 12/25/14.
 */
public class BrowserActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        Uri uri=getIntent().getData();
        WebView webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new Callback());
    }
    private class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}
