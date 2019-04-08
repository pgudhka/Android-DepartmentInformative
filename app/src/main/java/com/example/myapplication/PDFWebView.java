package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PDFWebView extends AppCompatActivity {

    WebView webView1;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfweb_view);

        Intent intent = getIntent();
        Bundle pdfviewer = intent.getExtras();
        String pdf = pdfviewer.getString("pdf");

        webView1=findViewById(R.id.pdfwebview);
        webView1.setBackgroundColor(Color.TRANSPARENT);
        webView1.getSettings().setJavaScriptEnabled(true);

        try {
            url = URLEncoder.encode(pdf,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        webView1.loadUrl("https://docs.google.com/viewerng/viewer?url="+url);

    }
}
