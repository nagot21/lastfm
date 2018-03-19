package com.nagot.lastfm.ui.album;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nagot.lastfm.R;
import com.nagot.lastfm.base.BaseFragment;
import com.nagot.lastfm.model.Album;
import com.nagot.lastfm.ui.album.adapter.AlbumAdapter;
import com.nagot.lastfm.ui.artist.ArtistFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nagot on 17/03/2018.
 */

public class AlbumFragment extends BaseFragment implements AlbumFragmentMvpView {
    @BindView(R.id.album_recycler_view)
    RecyclerView albumRecyclerView;
    @BindView(R.id.album_progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.album_empty_layout)
    View emptyLayout;
    @BindView(R.id.album_search_layout)
    View searchLayout;
    @BindView(R.id.search_item_text)
    TextView searchTextView;
    private AlbumAdapter mAdapter;
    private View.OnClickListener mOnClickListener;
    private AlbumFragmentMvpPresenter<AlbumFragmentMvpView> mPresenter;
    private OnItemSelectedListener mOnItemSelectedListener;

    public static AlbumFragment newInstance() {
        return new AlbumFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_album;
    }

    @Override
    protected void setUp(View view) {
        ButterKnife.bind(this, view);
        mPresenter = new AlbumFragmentPresenter<>();
        mPresenter.onAttach(this);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = albumRecyclerView.getChildLayoutPosition(view);
                Album album = mAdapter.getItemByPosition(position);

                mOnItemSelectedListener.onAlbumItemClicked(album.getName(), album.getArtist());
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchLayout.setVisibility(View.VISIBLE);
        searchTextView.setText(String.format(
                getString(R.string.press_search), getString(R.string.album)));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof AlbumFragment.OnItemSelectedListener) {
            mOnItemSelectedListener = (AlbumFragment.OnItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " interface must be implemented");
        }
    }

    @Override
    public void search(String search) {
        searchLayout.setVisibility(View.GONE);

        if (mAdapter != null) {
            mAdapter.clearItems();
        }
        mPresenter.getAlbum(search);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.error_occurred,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEmpty() {
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmpty() {
        emptyLayout.setVisibility(View.GONE);
    }

    @Override
    public void updateData(List<Album> albumList) {

        if (mAdapter == null) {
            mAdapter = new AlbumAdapter(albumList, getContext(), mOnClickListener);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL, false);
            albumRecyclerView.setLayoutManager(linearLayoutManager);
            albumRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.updateItems(albumList);
        }
    }

    public interface OnItemSelectedListener {

        void onAlbumItemClicked(String albumName, String artistName);

    }
}
