package com.viewpagerindicator.sample;

import com.example.viewpagesingle.R;
import com.viewpagerindicator.TitlePageIndicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class SampleTitlesDefault extends BaseSampleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_titles);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (TitlePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}