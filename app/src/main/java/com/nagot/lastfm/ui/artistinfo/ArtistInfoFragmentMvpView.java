package com.nagot.lastfm.ui.artistinfo;

import com.nagot.lastfm.base.BaseMvpView;
import com.nagot.lastfm.model.Artist;
import com.nagot.lastfm.model.ArtistInfo;

import java.util.List;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface ArtistInfoFragmentMvpView extends BaseMvpView {

    void updateData(ArtistInfo artistInfo);
}
