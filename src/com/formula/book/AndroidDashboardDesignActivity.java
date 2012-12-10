package com.formula.book;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class AndroidDashboardDesignActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);

 
		/**
		 * Creating all button instances
		 * */

		// Algebra button
		Button btn_algebra = (Button) findViewById(R.id.btn_algebra);	

		// Trigonometry button
		Button btn_trigonometry = (Button) findViewById(R.id.btn_trigonometry);

		// Geometry button
		Button btn_geometry = (Button) findViewById(R.id.btn_geometry);

		// Vectors button
		Button btn_vectors = (Button) findViewById(R.id.btn_vectors);

		// Integrals button
		Button btn_integrals = (Button) findViewById(R.id.btn_integrals);

		// Derivative button
		Button btn_derivative = (Button) findViewById(R.id.btn_derivative);

		/**
		 * Handling all button click events
		 * */

		// Listening to Algebra button click
		btn_algebra.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {				
				// Launching Algebra Screen
				Intent i = new Intent(getApplicationContext(),
						AlgebraActivity.class);
				startActivity(i);
				
			}
			
		});

		// Listening Trigonometry button click
		btn_trigonometry.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching Trigonometry Screen
				Intent i = new Intent(getApplicationContext(),
						TrigonometryActivity.class);
				startActivity(i);
			}
		});

		// Listening Geometry button click
		btn_geometry.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching Geometry Screen
				Intent i = new Intent(getApplicationContext(),
						GeometryActivity.class);
				startActivity(i);
			}
		});

		// Listening to Vectors button click
		btn_vectors.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching Vectors Screen
				Intent i = new Intent(getApplicationContext(),
						VectorsActivity.class);
				startActivity(i);
			}
		});

		// Listening to Integrals button click
		btn_integrals.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching Integrals Screen
				Intent i = new Intent(getApplicationContext(),
						IntegralsActivity.class);
				startActivity(i);
			}
		});

		// Listening to Derivative button click
		btn_derivative.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						DerivativeActivity.class);
				startActivity(i);
			}
		});
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
	
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()) {
			case R.id.menu_home:
				// app icon in action bar clicked: go home
				Intent intent = new Intent(this, AndroidDashboardDesignActivity.class);
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
