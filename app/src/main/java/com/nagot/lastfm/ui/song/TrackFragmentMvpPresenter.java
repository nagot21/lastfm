package com.nagot.lastfm.ui.song;

import com.nagot.lastfm.base.BaseMvpPresenter;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface TrackFragmentMvpPresenter<V extends TrackFragmentMvpView> extends BaseMvpPresenter<V> {

    void getTrack(String albumName);
}
