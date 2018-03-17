package com.nagot.lastfm.ui.artist;

import com.nagot.lastfm.base.BaseMvpView;
import com.nagot.lastfm.model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface ArtistFragmentMvpView extends BaseMvpView {

    void updateData(List<Artist> artists);
}
