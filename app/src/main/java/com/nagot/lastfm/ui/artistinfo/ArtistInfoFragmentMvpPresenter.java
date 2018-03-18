package com.nagot.lastfm.ui.artistinfo;

import com.nagot.lastfm.base.BaseMvpPresenter;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface ArtistInfoFragmentMvpPresenter<V extends ArtistInfoFragmentMvpView> extends BaseMvpPresenter<V> {

    void getArtistInfo(String artistName);
}
