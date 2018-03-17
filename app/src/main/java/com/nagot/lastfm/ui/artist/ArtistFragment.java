package com.nagot.lastfm.ui.artist;

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
import com.nagot.lastfm.model.Artist;
import com.nagot.lastfm.ui.artist.adapter.ArtistsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class ArtistFragment extends BaseFragment implements ArtistFragmentMvpView {
    @BindView(R.id.artist_recycler_view)
    RecyclerView artistsRecyclerView;
    @BindView(R.id.artist_progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.empty_layout)
    View emptyLayout;
    @BindView(R.id.search_layout)
    View searchLayout;
    @BindView(R.id.search_item_text)
    TextView searchTextView;
    private ArtistsAdapter mAdapter;
    private View.OnClickListener mOnClickListener;
    private ArtistFragmentMvpPresenter<ArtistFragmentMvpView> mPresenter;

    public static ArtistFragment newInstance() {
        return new ArtistFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_artist;
    }

    @Override
    protected void setUp(View view) {
        ButterKnife.bind(this, view);
        mPresenter = new ArtistFragmentPresenter<>();
        mPresenter.onAttach(this);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = artistsRecyclerView.getChildLayoutPosition(view);
                Artist artist = mAdapter.getItemByPostion(position);

                Toast.makeText(getContext(), artist.getName(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchLayout.setVisibility(View.VISIBLE);
        searchTextView.setText(String.format(
                getString(R.string.press_search), getString(R.string.artist)));
    }

    @Override
    public void search(String search) {
        searchLayout.setVisibility(View.GONE);

        if (mAdapter != null) {
            mAdapter.clearItems();
        }
        mPresenter.getArtist(search);
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
    public void updateData(List<Artist> artists) {

        if (mAdapter == null) {
            mAdapter = new ArtistsAdapter(artists, getContext(), mOnClickListener);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL, false);
            artistsRecyclerView.setLayoutManager(linearLayoutManager);
            artistsRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.updateItems(artists);
        }
    }

    /*public interface OnFragmentItemClickListener{

        void onItemClicked(Artist artist);

    }*/
}
