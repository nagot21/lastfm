package com.nagot.lastfm.ui.artist;

import com.nagot.lastfm.base.BaseMvpPresenter;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface ArtistFragmentMvpPresenter<V extends ArtistFragmentMvpView> extends BaseMvpPresenter<V> {

    void getArtist(String userName, String apiKey, int limit);
}
