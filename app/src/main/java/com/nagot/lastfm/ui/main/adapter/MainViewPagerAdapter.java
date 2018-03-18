package com.nagot.lastfm.ui.main.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.nagot.lastfm.R;
import com.nagot.lastfm.ui.album.AlbumFragment;
import com.nagot.lastfm.ui.artist.ArtistFragment;
import com.nagot.lastfm.ui.track.TrackFragment;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private static final int NUMBER_OF_ITEMS = 3;
    private static final int ARTISTS_INDEX = 0;
    private static final int ALBUMS_INDEX = 1;
    private static final int SONGS_INDEX = 2;
    private String artistsTitle;
    private String songsTitle;
    private String albumsTitle;
    private Hashtable<Integer, WeakReference<Fragment>> fragments;

    public MainViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.artistsTitle = context.getString(R.string.artists);
        this.songsTitle = context.getString(R.string.songs);
        this.albumsTitle = context.getString(R.string.albums);
        this.fragments = new Hashtable<>();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case ARTISTS_INDEX: {
                Fragment fr = ArtistFragment.newInstance();
                fragments.put(position, new WeakReference<>(fr));
                return fr;
            }
            case ALBUMS_INDEX: {
                Fragment fr = AlbumFragment.newInstance();
                fragments.put(position, new WeakReference<>(fr));
                return fr;
            }
            case SONGS_INDEX: {
                Fragment fr = TrackFragment.newInstance();
                fragments.put(position, new WeakReference<>(fr));
                return fr;
            }
        }
        return new ArtistFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case ARTISTS_INDEX: {
                return artistsTitle;
            }
            case ALBUMS_INDEX: {

                return albumsTitle;
            }
            case SONGS_INDEX: {
                return songsTitle;
            }
        }

        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return NUMBER_OF_ITEMS;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        fragments.remove(position);
    }

    public ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> list = new ArrayList<>();

        for (int i = 0; i < fragments.size(); i++) {
            list.add(fragments.get(i).get());
        }
        return list;
    }
}
