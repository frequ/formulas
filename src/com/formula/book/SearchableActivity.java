package com.formula.book;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class SearchableActivity extends Activity {
	
	private ProgressDialog pd;
	private SClient sc;
	
	private Handler uiHandler = new Handler(){
		
		public void handleMessage(Message msg){
			pd.dismiss();
			if (msg.what == 0){
				showRes((String)msg.obj);
			}
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		Intent intent = getIntent();
		if(Intent.ACTION_SEARCH.equals(intent.getAction())){
			String q = intent.getStringExtra(SearchManager.QUERY);
			doMySearch(q);
		}
	}
	
	private void doMySearch(String q) {
		pd = ProgressDialog.show(SearchableActivity.this, "Connecting...", "Please wait..", true,false);
		sc = new SClient(uiHandler, q);
		Thread t = new Thread(sc);
		t.start();
	}

	private void showRes(String obj) {
		TextView result = (TextView)findViewById(R.id.Text1);
		result.setMovementMethod(LinkMovementMethod.getInstance());		
		Spanned sp = Html.fromHtml(obj);
		result.setText(sp);
		
	}
}
