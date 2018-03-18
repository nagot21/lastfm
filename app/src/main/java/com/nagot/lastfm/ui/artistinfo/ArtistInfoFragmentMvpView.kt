package com.nagot.lastfm.ui.artistinfo

import com.nagot.lastfm.base.BaseMvpView
import com.nagot.lastfm.model.ArtistInfo

/**
 * Created by Nagot on 18/03/2018.
 */
interface ArtistInfoFragmentMvpView: BaseMvpView {

    fun updateData(artistInfo: ArtistInfo)
}