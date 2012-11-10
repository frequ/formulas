package com.formula.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class WebviewActivity extends Activity{
	
	public String url;
	public String header;
	
	public void onCreate (Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.test);
		
		
		/* Fetch data from intent start */
		Intent i = getIntent();
		Bundle bundle = i.getExtras();
		url = bundle.getString("url");
		header = bundle.getString("header");
		
		/* Changes actionbar text */
		TextView text = (TextView) findViewById(R.id.tv);
		text.setText(header);
		
		/* Launch webview */
		WebView webView = new WebView(getApplicationContext());
		webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(url);
	}
}
