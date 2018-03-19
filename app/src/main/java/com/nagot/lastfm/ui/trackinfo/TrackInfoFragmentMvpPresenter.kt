package com.nagot.lastfm.ui.trackinfo

import com.nagot.lastfm.base.BaseMvpPresenter

/**
 * Created by Nagot on 18/03/2018.
 */
interface TrackInfoFragmentMvpPresenter<V: TrackInfoFragmentMvpView>: BaseMvpPresenter<V> {

    fun getTrackInfo(trackName: String, artistName: String)
}