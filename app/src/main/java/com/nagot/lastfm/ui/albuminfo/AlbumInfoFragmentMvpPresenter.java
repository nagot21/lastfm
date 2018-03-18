package com.nagot.lastfm.ui.albuminfo;

import com.nagot.lastfm.base.BaseMvpPresenter;
import com.nagot.lastfm.ui.artistinfo.ArtistInfoFragmentMvpView;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface AlbumInfoFragmentMvpPresenter<V extends ArtistInfoFragmentMvpView> extends BaseMvpPresenter<V> {

    void getArtistInfo(String artistName);
}
