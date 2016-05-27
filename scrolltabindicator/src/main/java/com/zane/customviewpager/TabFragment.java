package com.zane.customviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {

	public static final String BUNDLE_TITLE = "title";
	private String mTitle = "DefaultValue";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Bundle bundle = getArguments();
		if(bundle != null)
			mTitle = bundle.getString(BUNDLE_TITLE);
		
		TextView textView = new TextView(getActivity());
		textView.setText(mTitle);
		textView.setGravity(Gravity.CENTER);
		
		return textView;
	}
	
	public static TabFragment newInstance(String title){
		Bundle bundle = new Bundle();
		bundle.putString(BUNDLE_TITLE, title);
		TabFragment tabFragment = new TabFragment();
		tabFragment.setArguments(bundle);
		return tabFragment;
	}
}
