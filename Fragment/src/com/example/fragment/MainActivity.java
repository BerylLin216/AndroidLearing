package com.example.fragment;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	ArticleFragment fragment1;
	Fragment2 fragment2;
	int sign = 1;
	
	FragmentTransaction transaction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();		
	}

	private void init() {
		// TODO Auto-generated method stub		
		transaction = getFragmentManager().beginTransaction();
		if(fragment1 == null){
			fragment1 = new ArticleFragment();
		}
		transaction.add(R.id.fragment_container, fragment1);
		transaction.commit();
		
		Button change = (Button)findViewById(R.id.change);
		change.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(sign == 1){
					if(fragment2 == null){
						fragment2 = new Fragment2();
					}
					
					transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.fragment_container, fragment2);
					transaction.commit();
					sign = 2;
				}
				else if (sign == 2){
					if(fragment1 == null){
						fragment1 = new ArticleFragment();
					}
					transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.fragment_container, fragment1);
					transaction.commit();
					sign = 1;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
