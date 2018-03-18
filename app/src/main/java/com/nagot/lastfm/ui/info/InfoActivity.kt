package com.nagot.lastfm.ui.info

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nagot.lastfm.R
import com.nagot.lastfm.base.BaseFragment
import com.nagot.lastfm.ui.albuminfo.AlbumInfoFragment
import com.nagot.lastfm.ui.artistinfo.ArtistInfoFragment
import com.nagot.lastfm.utils.ConstantsUtil

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val extras = intent.extras
        val artist = extras.getString("artist")
        val album = extras.getString("album")
        val track = extras.getString("track")
        val fragmentName = extras.getString("fragment")

        if (savedInstanceState == null) {
            startFragment(artist, album, track, fragmentName)
        }
    }

    private fun startFragment(artist: String, album: String, track: String,
                              fragmentName: String) {
        val bundle = Bundle()
        bundle.putString("artist", artist)

        val fragment: BaseFragment = when (fragmentName) {
            ConstantsUtil.ARTIST -> ArtistInfoFragment.newInstance()
            ConstantsUtil.ALBUM -> {
                bundle.putString("album", album)
                AlbumInfoFragment.newInstance()
            }
            else -> {
                bundle.putString("track", track)
                AlbumInfoFragment.newInstance()
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
