package com.nagot.lastfm.ui.albuminfo;

import com.nagot.lastfm.base.BaseMvpView;
import com.nagot.lastfm.model.ArtistInfo;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface AlbumInfoFragmentMvpView extends BaseMvpView {

    void updateData(ArtistInfo artistInfo);
}
