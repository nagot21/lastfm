package com.nagot.lastfm.ui.trackinfo

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.nagot.lastfm.R
import com.nagot.lastfm.base.BaseFragment
import com.nagot.lastfm.model.TrackInfo
import com.nagot.lastfm.utils.ImageLoaderUtil
import kotlinx.android.synthetic.main.fragment_track_info.*

/**
 * Created by Nagot on 18/03/2018.
 */
class TrackInfoFragment : BaseFragment(), TrackInfoFragmentMvpView {

    private lateinit var mPresenter: TrackInfoFragmentPresenter<TrackInfoFragmentMvpView>

    companion object {
        fun newInstance(): TrackInfoFragment {
            return TrackInfoFragment()
        }
    }

    override fun getFragmentLayout(): Int {
        return R.layout.fragment_track_info
    }

    override fun setUp(view: View?) {
        mPresenter = TrackInfoFragmentPresenter()
        mPresenter.onAttach(this)

        val artist = arguments.getString("artist")
        val track = arguments.getString("track")

        prepareToolbar()

        mPresenter.getTrackInfo(track, artist)
    }

    override fun search(search: String?) {
    }

    override fun showProgress() {
        track_info_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        track_info_progress_bar.visibility = View.GONE
    }

    override fun showError() {
        Toast.makeText(context, R.string.error_occurred,
                Toast.LENGTH_LONG).show()
    }

    override fun showEmpty() {
        track_info_empty_layout.visibility = View.VISIBLE
    }

    override fun hideEmpty() {
        track_info_empty_layout.visibility = View.GONE
    }

    override fun updateData(trackInfo: TrackInfo) {
        track_info_scroll_view.visibility = View.VISIBLE
        track_info_app_bar_layout.visibility = View.VISIBLE

        ImageLoaderUtil.loadImage(context, trackInfo.trackAlbum.imageUrl,
                R.drawable.last_fm_logo, track_info_artist_image)

        track_info_collapsing_toolbar_layout.title = trackInfo.name

        track_info_from_album_text.text = String.format(context.getString(R.string.from_album),
                trackInfo.trackAlbum.title)

        track_info_by_artist_text.text = String.format(context.getString(R.string.artist_by),
                trackInfo.trackAlbum.artist)

        track_info_wiki_text.text = if(trackInfo.wiki != null && !trackInfo.wiki.content.isBlank()){
            trackInfo.wiki.content
        } else {
            context.getText(R.string.no_info)
        }
    }

    private fun prepareToolbar(){
        (activity as AppCompatActivity)
                .setSupportActionBar(track_info_toolbar)
        (activity as AppCompatActivity)
                .supportActionBar?.setDisplayHomeAsUpEnabled(true)

        track_info_toolbar.setNavigationOnClickListener { activity.onBackPressed() }
    }
}