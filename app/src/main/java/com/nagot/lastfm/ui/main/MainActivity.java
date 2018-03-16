package com.nagot.lastfm.ui.main;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.nagot.lastfm.R;
import com.nagot.lastfm.ui.main.adapter.MainViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.main_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.main_edit_search)
    EditText searchEditText;
    private MainViewPagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpFragments();
    }

    private void setUpFragments(){
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
