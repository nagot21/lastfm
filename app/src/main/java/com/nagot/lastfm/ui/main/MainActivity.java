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

    /*
    * The project was developed using MVP Pattern, Java for the search part which consists in:
    * Artists, Albums and Songs.
    *
    * All the call for the Last.Fm api were made using Retrofit2 in combination with Rxjava2.
    *
    * I didn't have enough time to implement Dagger2 nor TDD to the project since I was short in time
    * to do so and also for my little experience with both libraries.
    * */

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

    private void goToNextActivity(String artistName, String artistAlbum, String track,
                                  String fragmentName) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra(ConstantsUtil.ARTIST, artistName);
        intent.putExtra(ConstantsUtil.ALBUM, artistAlbum);
        intent.putExtra(ConstantsUtil.TRACK, track);
        intent.putExtra(ConstantsUtil.FRAGMENT, fragmentName);
        startActivity(intent);
    }

    @Override
    public void onArtistItemClicked(String artistName) {
        goToNextActivity(artistName, "", "", ConstantsUtil.ARTIST);
    }

    @Override
    public void onAlbumItemClicked(String albumName, String artistName) {
        goToNextActivity(artistName, albumName, "", ConstantsUtil.ALBUM);
    }

    @Override
    public void onTrackItemClicked(String trackName, String artistName) {
        goToNextActivity(artistName, "", trackName, ConstantsUtil.TRACK);
    }
}
