package com.nagot.lastfm.ui.album;

import com.nagot.lastfm.base.BaseMvpPresenter;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface AlbumFragmentMvpPresenter<V extends AlbumFragmentMvpView> extends BaseMvpPresenter<V> {

    void getAlbum(String albumName);
}
