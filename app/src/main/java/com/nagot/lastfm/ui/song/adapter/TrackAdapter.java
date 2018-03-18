package com.nagot.lastfm.ui.song.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nagot.lastfm.R;
import com.nagot.lastfm.model.Track;
import com.nagot.lastfm.utils.ImageLoaderUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {
    private List<Track> mTrackList;
    private Context mContext;
    private View.OnClickListener mOnItemClickListener;

    public TrackAdapter(List<Track> trackList, Context mContext,
                        View.OnClickListener mOnItemClickListener) {
        this.mTrackList = trackList;
        this.mContext = mContext;
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_track, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Track track = mTrackList.get(position);

        ImageLoaderUtil.loadImage(mContext, track.getImageUrl(),
                R.drawable.microphone, holder.albumImage);

        holder.trackName.setText(track.getName());

        holder.artistName.setText(String.format(
                mContext.getString(R.string.song_by), track.getArtist()));
    }

    @Override
    public int getItemCount() {
        return mTrackList.size();
    }

    public Track getItemByPosition(int position) {
        return mTrackList.get(position);
    }

    public void updateItems(List<Track> trackList) {
        mTrackList = trackList;
        notifyDataSetChanged();
    }

    public void clearItems() {
        if (mTrackList != null) {
            mTrackList.clear();
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_track_image_view)
        ImageView albumImage;
        @BindView(R.id.item_track_name)
        TextView trackName;
        @BindView(R.id.item_track_artist_name)
        TextView artistName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_track_card_view)
        void onItemClicked(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(view);
            }
        }
    }
}
