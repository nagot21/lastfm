package com.nagot.lastfm.ui.main;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nagot.lastfm.R;
import com.nagot.lastfm.base.BaseFragment;
import com.nagot.lastfm.ui.album.AlbumFragment;
import com.nagot.lastfm.ui.artist.ArtistFragment;
import com.nagot.lastfm.ui.info.InfoActivity;
import com.nagot.lastfm.ui.main.adapter.MainViewPagerAdapter;
import com.nagot.lastfm.ui.track.TrackFragment;
import com.nagot.lastfm.utils.ConstantsUtil;
import com.nagot.lastfm.utils.KeyboardUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class MainActivity extends AppCompatActivity
        implements ArtistFragment.OnItemSelectedListener,
        AlbumFragment.OnItemSelectedListener, TrackFragment.OnItemSelectedListener{

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

    private void setUpFragments() {
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @OnEditorAction(R.id.main_edit_search)
    boolean onEditAction(TextView textView, int actionId) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            if (!TextUtils.isEmpty(textView.getText().toString())) {
                searchUser(textView.getText().toString());
            }
            KeyboardUtil
                    .looseSearchEditTextFocus(this, getWindow(),
                            searchEditText);
            return true;
        }
        return false;
    }

    private void searchUser(String userName) {
        for (Fragment fragment : mAdapter.getFragments()) {
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).search(userName);
            }
        }
    }

    private void goToNextActivity(String info, String fragmentName) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra("info", info);
        intent.putExtra("fragment", fragmentName);
        startActivity(intent);
    }

    @Override
    public void onArtistItemClicked(String artistName) {
        goToNextActivity(artistName, ConstantsUtil.ARTIST);
    }

    @Override
    public void onAlbumItemClicked(String albumName) {
        goToNextActivity(albumName, ConstantsUtil.ALBUM);
    }

    @Override
    public void onTrackItemClicked(String trackName) {
        goToNextActivity(trackName, ConstantsUtil.TRACK);
    }
}
