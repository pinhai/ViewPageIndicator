package com.shizhefei.indicator.setting;

import com.example.myapplication.R;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;

import android.app.Activity;
import android.support.v4.view.ViewPager;

public class SettingActivity extends Activity {
	private IndicatorViewPager indicatorViewPager;

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		ViewPager viewPager = (ViewPager) findViewById(R.id.setting_viewPager);
		Indicator indicator = (Indicator) findViewById(R.id.setting_indicator);
		indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
	};
}
