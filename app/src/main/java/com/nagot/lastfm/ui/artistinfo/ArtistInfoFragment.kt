package com.nagot.lastfm.ui.artistinfo

import android.view.View
import com.nagot.lastfm.R
import com.nagot.lastfm.base.BaseFragment

/**
 * Created by Nagot on 18/03/2018.
 */
class ArtistInfoFragment: BaseFragment() {

    companion object {
        fun newInstance(): ArtistInfoFragment {
            return ArtistInfoFragment()
        }
    }

    override fun getFragmentLayout(): Int {
        return R.layout.fragment_artist_info
    }

    override fun setUp(view: View?) {
    }

    override fun search(search: String?) {
    }
}