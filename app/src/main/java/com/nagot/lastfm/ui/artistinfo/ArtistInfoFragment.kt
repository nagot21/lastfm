package com.nagot.lastfm.ui.artistinfo

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.nagot.lastfm.R
import com.nagot.lastfm.base.BaseFragment
import com.nagot.lastfm.model.ArtistInfo
import com.nagot.lastfm.utils.ImageLoaderUtil
import kotlinx.android.synthetic.main.fragment_artist_info.*

/**
 * Created by Nagot on 18/03/2018.
 */
class ArtistInfoFragment : BaseFragment(), ArtistInfoFragmentMvpView {
    private lateinit var mPresenter: ArtistInfoFragmentPresenter<ArtistInfoFragmentMvpView>

    companion object {
        fun newInstance(): ArtistInfoFragment {
            return ArtistInfoFragment()
        }
    }

    override fun getFragmentLayout(): Int {
        return R.layout.fragment_artist_info
    }

    override fun setUp(view: View?) {
        mPresenter = ArtistInfoFragmentPresenter()
        mPresenter.onAttach(this)

        val artistName = arguments.getString("artist")

        prepareToolbar()

        mPresenter.getArtistInfo(artistName)
    }

    override fun search(search: String?) {
    }

    override fun showProgress() {
        artist_info_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        artist_info_progress_bar.visibility = View.GONE
    }

    override fun showError() {
        Toast.makeText(context, R.string.error_occurred,
                Toast.LENGTH_LONG).show()
    }

    override fun showEmpty() {
        artist_info_empty_layout.visibility = View.VISIBLE
    }

    override fun hideEmpty() {
        artist_info_empty_layout.visibility = View.GONE
    }

    override fun updateData(artistInfo: ArtistInfo) {
        artist_info_app_bar_layout.visibility = View.VISIBLE
        artist_info_scroll_view.visibility = View.VISIBLE

        ImageLoaderUtil.loadImage(context, artistInfo.imageUrl,
                R.drawable.last_fm_logo, artist_info_artist_image)

        artist_info_collapsing_toolbar_layout.title = artistInfo.name

        artist_info_bio.text = if(!artistInfo.artistBiography.content.isBlank()){
            artistInfo.artistBiography.content
        } else {
            artistInfo.artistBiography.summary
        }
    }

    private fun prepareToolbar(){
        (activity as AppCompatActivity)
                .setSupportActionBar(artist_info_toolbar)
        (activity as AppCompatActivity)
                .supportActionBar?.setDisplayHomeAsUpEnabled(true)

        artist_info_toolbar.setNavigationOnClickListener { activity.onBackPressed() }
    }
}