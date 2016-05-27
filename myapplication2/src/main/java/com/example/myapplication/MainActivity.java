/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */

package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {


	private CustomPagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;


	private int currentColor = 0xFF666666;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tabs = (CustomPagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
				.getDisplayMetrics());
		pager.setPageMargin(pageMargin);
		tabs.setViewPager(pager);
		tabs.setIndicatorColor(currentColor);
		tabs.setTabPaddingLeftRight(30);
		tabs.setTabBackground(getResources().getColor(R.color.background_tab_pressed));
	}



	public class MyPagerAdapter extends FragmentPagerAdapter implements CustomPagerSlidingTabStrip.CustomTabProvider{

		private final String[] TITLES = { "Categories", "Home", "Top HomePaid", "Top HomeHomeFree", "Top HomeGrossing", "Top",
				"Top New Free", "Trending" };

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			return SuperAwesomeCardFragment.newInstance(position);
		}

		@Override
		public View getSelectTabView(int position, View convertView) {
			if (convertView == null){
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_item, null);
			}
			TextView textView = (TextView) convertView.findViewById(R.id.text_view);
			textView.setText("我被选中"+position+TITLES[position]);
			return convertView;
		}

		@Override
		public View getDisSelectTabView(int position, View convertView) {
			if (convertView == null){
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_item, null);
			}
			TextView textView = (TextView) convertView.findViewById(R.id.text_view);
			textView.setText("我被选中"+position+TITLES[position]);
			return convertView;
		}
	}

}