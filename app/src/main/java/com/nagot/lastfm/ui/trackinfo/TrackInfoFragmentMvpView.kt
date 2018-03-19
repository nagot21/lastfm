package com.nagot.lastfm.ui.trackinfo

import com.nagot.lastfm.base.BaseMvpView
import com.nagot.lastfm.model.TrackInfo

/**
 * Created by Nagot on 18/03/2018.
 */
interface TrackInfoFragmentMvpView: BaseMvpView {

    fun updateData(trackInfo: TrackInfo)
}