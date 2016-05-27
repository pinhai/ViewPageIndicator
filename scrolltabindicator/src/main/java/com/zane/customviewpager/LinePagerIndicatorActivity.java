package com.zane.customviewpager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.scrolltabindicator.R;
import com.zane.customviewpager.view.ViewPagerLineIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class LinePagerIndicatorActivity extends FragmentActivity {

	/**
	 * 标题数据，可以有多个(直接往后面加数据就是了)
	 */
	private List<String> mDatas = Arrays.asList("ANDROID", "APPLE", "ZANE", "WINPHONE","ANDROID", "APPLE", "ZANE",
			"WINPHONE","ANDROID", "APPLE", "ZANE", "WINPHONE");
	private ViewPagerLineIndicator indicator;
	private ViewPager viewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_line_pager_indicator);

		findView();
		initData();
		setView();
	}
	
	private void findView() {
		indicator = (ViewPagerLineIndicator) findViewById(R.id.viewPagerLineIndicator);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
	}

	private void initData() {
        // 创建 fragment
		for (String data : mDatas) {
			TabFragment tabFragment = TabFragment.newInstance(data);
			mFragments.add(tabFragment);
		}
        
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mFragments.get(arg0);
			}
		};
	}

	private void setView() {
		// 设置Tab上的标题
		indicator.setTabItemTitles(mDatas);
		viewPager.setAdapter(mAdapter);
		// 设置关联的ViewPager
		indicator.setViewPager(viewPager, 0);
	}

}
