package com.nagot.lastfm.ui.artist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nagot.lastfm.R;

import com.nagot.lastfm.model.Artist;
import com.nagot.lastfm.utils.ImageLoaderUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {
    private List<Artist> mArtistList;
    private Context mContext;
    private View.OnClickListener mOnItemClickListener;

    public ArtistsAdapter(List<Artist> artistList, Context mContext,
                          View.OnClickListener mOnItemClickListener) {
        this.mArtistList = artistList;
        this.mContext = mContext;
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist artist = mArtistList.get(position);
        ImageLoaderUtil.loadImage(mContext, artist.getImageUrl(),
                R.drawable.microphone, holder.artistImage);
        holder.artistName.setText(artist.getName());

    }

    @Override
    public int getItemCount() {
        return mArtistList.size();
    }

    public Artist getItemByPostion(int position) {
        return mArtistList.get(position);
    }

    public void updateItems(List<Artist> artistList) {
        mArtistList = artistList;
        notifyDataSetChanged();
    }

    public void clearItems() {
        if (mArtistList != null) {
            mArtistList.clear();
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_artist_image_view)
        ImageView artistImage;
        @BindView(R.id.item_artist_name)
        TextView artistName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_artist_card_view)
        void onItemClicked(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(view);
            }
        }
    }
}
