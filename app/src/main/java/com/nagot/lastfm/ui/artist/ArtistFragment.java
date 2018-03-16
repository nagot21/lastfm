package com.nagot.lastfm.ui.artist;

import android.view.View;

import com.nagot.lastfm.R;
import com.nagot.lastfm.base.BaseFragment;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class ArtistFragment extends BaseFragment {

    public static ArtistFragment newInstance() {
        return new ArtistFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_artist;
    }

    @Override
    protected void setUp(View view) {

    }
}
