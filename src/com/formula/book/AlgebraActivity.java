package com.formula.book;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.formula.book.R;

public class AlgebraActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_layout);
		
		/** Changes actionbar text */
		String innerMath = "Algebra";
		TextView text = (TextView) findViewById(R.id.tv);
		text.setText(innerMath);
	}

}
