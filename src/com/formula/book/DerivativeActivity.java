package com.formula.book;

import android.app.ListActivity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class DerivativeActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_layout);
		
		String[] subCategories = new String[] { "Basics", "Basics II", "Definition", "Exponentials", "Higher Order Derivatives", 
				"Derivate of Exponential and Logarithmic functions", "Derivative of Trigonometric Functions"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, subCategories);
		setListAdapter(adapter);
		
		/** Changes actionbar text */
		String innerMath = "Derivative";
		TextView text = (TextView) findViewById(R.id.tv);
		text.setText(innerMath);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
			
		String item = (String) getListAdapter().getItem(position);
		
			if(item.equals("Basics")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/derivative-basic.html");
				bundle.putString("header", "Derivative / Basics");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Basics II")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/derivative-basic2.html");
				bundle.putString("header", "Derivative / Basics II");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Definition")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/derivative-definition.html");
				bundle.putString("header", "Derivative / Definition");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Exponentials")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/derivative-exponential.html");
				bundle.putString("header", "Derivative / Exponentials");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Higher Order Derivatives")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/derivative-higher.html");
				bundle.putString("header", "Derivative / Higher Order Derivatives");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Derivate of Exponential and Logarithmic functions")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/derivative-hyperbolic.html");
				bundle.putString("header", "Derivative / Hyperbolic");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Derivative of Trigonometric Functions")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/derivative-trigonometric.html");
				bundle.putString("header", "Derivative / Trigonometric Functions");
				i.putExtras(bundle);
				startActivity(i);
			}
			
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
			
		default:
			return super.onOptionsItemSelected(item);

		}
	}
}

