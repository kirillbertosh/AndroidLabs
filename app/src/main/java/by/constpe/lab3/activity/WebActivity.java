package by.constpe.lab3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import by.constpe.lab3.R;

public class WebActivity extends AppCompatActivity {
    private WebView webView;

    private class CustomWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Wikipedia");

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if(webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
                default:
                    return super.onOptionsItemSelected(menuItem);
            }
        }
    }
}
