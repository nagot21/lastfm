package com.nagot.lastfm.ui.info

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nagot.lastfm.R
import com.nagot.lastfm.base.BaseFragment
import com.nagot.lastfm.ui.albuminfo.AlbumInfoFragment
import com.nagot.lastfm.ui.artistinfo.ArtistInfoFragment
import com.nagot.lastfm.ui.trackinfo.TrackInfoFragment
import com.nagot.lastfm.utils.ConstantsUtil

class InfoActivity : AppCompatActivity() {

    /*This simple activity just handles the fragments point to the right one as soon as it is
    * activated
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val extras = intent.extras
        val artist = extras.getString(ConstantsUtil.ARTIST)
        val album = extras.getString(ConstantsUtil.ALBUM)
        val track = extras.getString(ConstantsUtil.TRACK)
        val fragmentName = extras.getString(ConstantsUtil.FRAGMENT)

        if (savedInstanceState == null) {
            startFragment(artist, album, track, fragmentName)
        }
    }

    private fun startFragment(artist: String, album: String, track: String,
                              fragmentName: String) {
        val bundle = Bundle()
        bundle.putString(ConstantsUtil.ARTIST, artist)

        val fragment: BaseFragment = when (fragmentName) {
            ConstantsUtil.ARTIST -> ArtistInfoFragment.newInstance()
            ConstantsUtil.ALBUM -> {
                bundle.putString(ConstantsUtil.ALBUM, album)
                AlbumInfoFragment.newInstance()
            }
            else -> {
                bundle.putString(ConstantsUtil.TRACK, track)
                TrackInfoFragment.newInstance()
            }
        }

        fragment.arguments = bundle

        supportFragmentManager
                .beginTransaction()
                .add(R.id.info_frame_layout,
                        fragment,
                        ConstantsUtil.ARTIST)
                .commit()
    }
}
