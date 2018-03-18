package com.nagot.lastfm.ui.albuminfo

import com.nagot.lastfm.base.BaseMvpPresenter

/**
 * Created by Nagot on 18/03/2018.
 */
interface AlbumInfoFragmentMvpPresenter<V: AlbumInfoFragmentMvpView>: BaseMvpPresenter<V> {

    fun getAlbumInfo(albumName: String, artistName: String)
}