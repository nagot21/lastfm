package com.nagot.lastfm.ui.album.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nagot.lastfm.R;
import com.nagot.lastfm.model.Album;
import com.nagot.lastfm.utils.ImageLoaderUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<Album> mAlbumList;
    private Context mContext;
    private View.OnClickListener mOnItemClickListener;

    public AlbumAdapter(List<Album> albumList, Context mContext,
                        View.OnClickListener mOnItemClickListener) {
        this.mAlbumList = albumList;
        this.mContext = mContext;
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album album = mAlbumList.get(position);

        ImageLoaderUtil.loadImage(mContext, album.getImageUrl(),
                R.drawable.microphone, holder.albumImage);

        holder.albumName.setText(album.getName());

        holder.artistName.setText(String.format(
                mContext.getString(R.string.album_by), album.getArtist()));
    }

    @Override
    public int getItemCount() {
        return mAlbumList.size();
    }

    public Album getItemByPosition(int position) {
        return mAlbumList.get(position);
    }

    public void updateItems(List<Album> albumList) {
        mAlbumList = albumList;
        notifyDataSetChanged();
    }

    public void clearItems() {
        if (mAlbumList != null) {
            mAlbumList.clear();
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_album_image_view)
        ImageView albumImage;
        @BindView(R.id.item_album_name)
        TextView albumName;
        @BindView(R.id.item_album_artist_name)
        TextView artistName;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_album_card_view)
        void onItemClicked(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(view);
            }
        }
    }
}
