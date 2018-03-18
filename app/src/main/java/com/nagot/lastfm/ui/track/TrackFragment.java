package com.nagot.lastfm.ui.track;

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
import com.nagot.lastfm.model.Track;
import com.nagot.lastfm.ui.artist.ArtistFragment;
import com.nagot.lastfm.ui.track.adapter.TrackAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nagot on 18/03/2018.
 */

public class TrackFragment extends BaseFragment implements TrackFragmentMvpView {
    @BindView(R.id.song_recycler_view)
    RecyclerView songRecyclerView;
    @BindView(R.id.song_progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.song_empty_layout)
    View emptyLayout;
    @BindView(R.id.song_search_layout)
    View searchLayout;
    @BindView(R.id.search_item_text)
    TextView searchTextView;
    private TrackAdapter mAdapter;
    private View.OnClickListener mOnClickListener;
    private TrackFragmentMvpPresenter<TrackFragmentMvpView> mPresenter;
    private OnItemSelectedListener mOnItemSelectedListener;

    public static TrackFragment newInstance() {
        return new TrackFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_song;
    }

    @Override
    protected void setUp(View view) {
        ButterKnife.bind(this, view);
        mPresenter = new TrackFragmentPresenter<>();
        mPresenter.onAttach(this);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = songRecyclerView.getChildLayoutPosition(view);
                Track track = mAdapter.getItemByPosition(position);

                mOnItemSelectedListener.onTrackItemClicked(track.getName());
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchLayout.setVisibility(View.VISIBLE);
        searchTextView.setText(String.format(
                getString(R.string.press_search), getString(R.string.song)));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof TrackFragment.OnItemSelectedListener) {
            mOnItemSelectedListener = (TrackFragment.OnItemSelectedListener) context;
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
        mPresenter.getTrack(search);
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
    public void updateData(List<Track> trackList) {

        if (mAdapter == null) {
            mAdapter = new TrackAdapter(trackList, getContext(), mOnClickListener);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL, false);
            songRecyclerView.setLayoutManager(linearLayoutManager);
            songRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.updateItems(trackList);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.onDetach();
    }

    public interface OnItemSelectedListener {

        void onTrackItemClicked(String trackName);

    }
}
