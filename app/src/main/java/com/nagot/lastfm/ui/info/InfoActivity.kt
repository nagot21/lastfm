package com.nagot.lastfm.ui.info

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nagot.lastfm.R
import com.nagot.lastfm.ui.artistinfo.ArtistInfoFragment
import com.nagot.lastfm.utils.ConstantsUtil

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val extras = intent.extras
        val info = extras.getString("info")
        val fragmentName = extras.getString("fragment")

        //Toast.makeText(this, info, Toast.LENGTH_LONG).show()
        if (savedInstanceState == null) {
            startFragment(fragmentName, info)
        }
    }

    private fun startFragment(fragmentName: String, info: String) {
        val bundle = Bundle()
        bundle.putString("info", info)
        val fragment = ArtistInfoFragment.newInstance()
        fragment.arguments = bundle

        supportFragmentManager
                .beginTransaction()
                .add(R.id.info_frame_layout,
                        ArtistInfoFragment.newInstance(),
                        ConstantsUtil.ARTIST)
                .commit()
    }

}
