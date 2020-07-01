package com.example.toolbox;

import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WebWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_weather);
        WebView webView = (WebView) findViewById(R.id.weather_web);
        webView.loadUrl("https://www.heweather.com/");
    }
}
