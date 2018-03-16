package com.nagot.lastfm.ui.artist;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class ArtistFragmentPresenter<V extends ArtistFragmentMvpView>
        implements ArtistFragmentMvpPresenter<V> {
    private ArtistFragmentMvpView mView;

    @Override
    public void onAttach(V view) {
        this.mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    @Override
    public void getArtist(String userName, String apiKey, int limit) {
        //TODO HERE WE GET THE DATA FROM THE API USING RX JAVA
    }
}
