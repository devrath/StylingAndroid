package com.example.stylingandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTwo extends Fragment{

	Button btn;


	public static FragmentTwo newInstance(){
		Log.d("FragmentTwo", "newInstance");
		FragmentTwo fragment = new FragmentTwo();
		return  fragment;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("FragmentOne", "onCreateView");
		View view=inflater.inflate(R.layout.fragment_two, container, false);

		btn=(Button) view.findViewById(R.id.button1);

		return view;
	}


	@Override
	public void onStart() {
		super.onStart();

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentManager manager = getActivity().getSupportFragmentManager();
				Fragment frgObj=FragmentOne.newInstance();
				FragmentTransaction ft = manager.beginTransaction();
				ft.replace(R.id.container, frgObj,"FragmentTwo");
				ft.addToBackStack(null);
				ft.commit();				
			}
		});
	}
}
