package com.formula.book;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.SearchView;
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
	
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView mSearchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
		mSearchView.setSearchableInfo(info);
		mSearchView.setIconifiedByDefault(true);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_home:
			// app home icon clicked: go home
			Intent intent = new Intent(this,
					AndroidDashboardDesignActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
			
		case R.id.menu_search:
			onSearchRequested();
			return true;

		default:
			return super.onOptionsItemSelected(item);

		}
	}
}
