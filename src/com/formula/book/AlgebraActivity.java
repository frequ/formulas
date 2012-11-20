<<<<<<< HEAD
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
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.listview_layout);
		
		
		String[] subCategories = new String[] { "Elementary Algebra", "Polymonials", "Abstract Algebra"
				, "Abstract Algebra", "Abstract Algebra", "Abstract Algebra", "Abstract Algebra"};
		
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
		
			if(item.equals("Polymonials")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/hello.htm");
				bundle.putString("header", "Algebra / Polymonials");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Elementary Algebra")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/0.htm");
				bundle.putString("header", "Algebra / Elementary Algebra");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Abstract Algebra")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/2.htm");
				bundle.putString("header", "Algebra / Abstract Algebra");
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
			
		case R.id.menu_search:
			onSearchRequested();
			return true;

		default:
			return super.onOptionsItemSelected(item);

		}
	}
}
=======
<<<<<<< HEAD
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
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.listview_layout);
		
		
		String[] subCategories = new String[] { "Elementary Algebra", "Polymonials", "Abstract Algebra"
				, "Abstract Algebra", "Abstract Algebra", "Abstract Algebra", "Abstract Algebra"};
		
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
		
			if(item.equals("Polymonials")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/hello.htm");
				bundle.putString("header", "Algebra / Polymonials");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Elementary Algebra")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/0.htm");
				bundle.putString("header", "Algebra / Elementary Algebra");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Abstract Algebra")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/2.htm");
				bundle.putString("header", "Algebra / Abstract Algebra");
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
			
		case R.id.menu_search:
			onSearchRequested();
			return true;

		default:
			return super.onOptionsItemSelected(item);

		}
	}
}
=======
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
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.listview_layout);
		
		
		String[] subCategories = new String[] { "Elementary Algebra", "Polymonials", "Abstract Algebra"
				, "Abstract Algebra", "Abstract Algebra", "Abstract Algebra", "Abstract Algebra"};
		
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
		
			if(item.equals("Polymonials")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/hello.htm");
				bundle.putString("header", "Algebra / Polymonials");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Elementary Algebra")){
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/0.htm");
				bundle.putString("header", "Algebra / Elementary Algebra");
				i.putExtras(bundle);
				startActivity(i);
				
			}else if(item.equals("Abstract Algebra")){				
				Intent i = new Intent(getApplicationContext(),
						WebviewActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("url","file:///android_asset/html/2.htm");
				bundle.putString("header", "Algebra / Abstract Algebra");
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
			
		case R.id.menu_search:
			onSearchRequested();
			return true;

		default:
			return super.onOptionsItemSelected(item);

		}
	}
}
>>>>>>> origin
>>>>>>> origin/master
