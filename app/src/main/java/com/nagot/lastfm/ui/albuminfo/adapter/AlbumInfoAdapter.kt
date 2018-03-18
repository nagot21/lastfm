package com.nagot.lastfm.ui.albuminfo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nagot.lastfm.R
import com.nagot.lastfm.model.AlbumTrack
import kotlinx.android.synthetic.main.item_album_track.view.*

/**
 * Created by Nagot on 18/03/2018.
 */
class AlbumInfoAdapter(private val albumTrackList: List<AlbumTrack>) :
        RecyclerView.Adapter<AlbumInfoAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_album_track, parent, false))
    }

    override fun getItemCount(): Int {
        return albumTrackList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(context, albumTrackList, position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(context: Context, albumTrackList: List<AlbumTrack>, position: Int) {

            val trackNumber = position + 1

            itemView.item_album_track_text.text = String.format(context.getString(R.string.track_number),
                    trackNumber.toString(), albumTrackList[position].name)
        }
    }
}