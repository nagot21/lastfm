package com.nagot.lastfm.ui.albuminfo

import com.nagot.lastfm.base.BaseMvpView
import com.nagot.lastfm.model.AlbumInfo

/**
 * Created by Nagot on 18/03/2018.
 */
interface AlbumInfoFragmentMvpView: BaseMvpView {

    fun updateData(albumInfo: AlbumInfo)
}