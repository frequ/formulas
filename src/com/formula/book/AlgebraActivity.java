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

public class AlgebraActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_layout);
		
		String[] subCategories = new String[] { "Formulas","Identities"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, subCategories);
		setListAdapter(adapter);
		
		
		
		/** Changes actionbar text */
		String innerMath = "Algebra"; 
		TextView text = (TextView) findViewById(R.id.tv);
		text.setText(innerMath);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
			
		String item = (String) getListAdapter().getItem(position);
		
			if(item.equals("Formulas")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/algebra/algebraic-formulas/algebraic-formulas.html");
				bundle.putString("header", "Algebra / Algebraic Formulas");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Identities")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/algebra/algebraic-identities/algebraic-identities.html");
				bundle.putString("header", "Algebra / Algebraic Identities");
				i.putExtras(bundle);
				startActivity(i);
				
			}
			
			
	  }

	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.landing, menu);
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

