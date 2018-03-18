package com.nagot.lastfm.ui.albuminfo

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.nagot.lastfm.R
import com.nagot.lastfm.base.BaseFragment
import com.nagot.lastfm.model.AlbumInfo
import com.nagot.lastfm.model.AlbumTrack
import com.nagot.lastfm.ui.albuminfo.adapter.AlbumInfoAdapter
import com.nagot.lastfm.utils.ImageLoaderUtil
import kotlinx.android.synthetic.main.fragment_album_info.*

/**
 * Created by Nagot on 18/03/2018.
 */
class AlbumInfoFragment : BaseFragment(), AlbumInfoFragmentMvpView {

    private lateinit var mPresenter: AlbumInfoFragmentPresenter<AlbumInfoFragmentMvpView>
    private var mAdapter: AlbumInfoAdapter? = null

    companion object {
        fun newInstance(): AlbumInfoFragment {
            return AlbumInfoFragment()
        }
    }

    override fun getFragmentLayout(): Int {
        return R.layout.fragment_album_info
    }

    override fun setUp(view: View?) {
        mPresenter = AlbumInfoFragmentPresenter()
        mPresenter.onAttach(this)

        val artist = arguments.getString("artist")
        val album = arguments.getString("album")

        prepareToolbar()

        mPresenter.getAlbumInfo(album, artist)
    }

    override fun search(search: String?) {
    }

    override fun showProgress() {
        album_info_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        album_info_progress_bar.visibility = View.GONE
    }

    override fun showError() {
        Toast.makeText(context, R.string.error_occurred,
                Toast.LENGTH_LONG).show()
    }

    override fun showEmpty() {
        album_info_empty_layout.visibility = View.VISIBLE
    }

    override fun hideEmpty() {
        album_info_empty_layout.visibility = View.GONE
    }

    override fun updateData(albumInfo: AlbumInfo) {
        prepareAdapter(albumInfo.tracks.albumTrackList)

        album_info_scroll_view.visibility = View.VISIBLE
        album_info_app_bar_layout.visibility = View.VISIBLE

        ImageLoaderUtil.loadImage(context, albumInfo.imageUrl,
                R.drawable.last_fm_logo, album_info_artist_image)

        album_info_collapsing_toolbar_layout.title = albumInfo.name

        album_info_name_title.text = String.format(context.getString(R.string.album_by),
                albumInfo.artist)

        album_info_wiki_text.text = if(albumInfo.wiki != null && !albumInfo.wiki.content.isBlank()){
            albumInfo.wiki.content
        } else {
            context.getText(R.string.no_info)
        }
    }

    private fun prepareToolbar(){
        (activity as AppCompatActivity)
                .setSupportActionBar(album_info_toolbar)
        (activity as AppCompatActivity)
                .supportActionBar?.setDisplayHomeAsUpEnabled(true)

        album_info_toolbar.setNavigationOnClickListener { activity.onBackPressed() }
    }

    private fun prepareAdapter(albumTrackList: List<AlbumTrack>){
        if (mAdapter == null){
            mAdapter = AlbumInfoAdapter(albumTrackList)
            val linearLayoutManager = LinearLayoutManager(context,
                    LinearLayoutManager.VERTICAL, false)
            album_info_recycler_view.layoutManager = linearLayoutManager
            album_info_recycler_view.adapter = mAdapter
        }
    }

    override fun onDetach() {
        super.onDetach()
        mPresenter.onDetach()
    }
}