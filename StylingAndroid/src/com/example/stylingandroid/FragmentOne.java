package com.example.stylingandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;

public class FragmentOne extends Fragment{

	Button btn;

	public static FragmentOne newInstance(){
		FragmentOne fragment = new FragmentOne();
		return  fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_one, container, false);

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
				Fragment frgObj=FragmentTwo.newInstance();
				FragmentTransaction ft = manager.beginTransaction();
				ft.replace(R.id.container, frgObj,"FragmentOne");
				ft.addToBackStack(null);
				ft.commit();				
			}
		});
	}
}
