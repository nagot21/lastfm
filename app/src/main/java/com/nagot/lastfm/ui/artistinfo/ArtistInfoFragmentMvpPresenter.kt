package com.nagot.lastfm.ui.artistinfo

import com.nagot.lastfm.base.BaseMvpPresenter

/**
 * Created by Nagot on 18/03/2018.
 */
interface ArtistInfoFragmentMvpPresenter<V: ArtistInfoFragmentMvpView>: BaseMvpPresenter<V> {

    fun getArtistInfo(artistName: String)
}