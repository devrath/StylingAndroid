package com.example.stylingandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		//First fragment should be mounted on oncreate of main activity
		if (savedInstanceState == null) {  
		
			Fragment newFragment = FragmentOne.newInstance();  
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();  
			ft.replace(R.id.container, newFragment).addToBackStack(null).commit();  
		}
	}

}
