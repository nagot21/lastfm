package com.nagot.lastfm.ui.track;

import com.nagot.lastfm.base.BaseMvpView;
import com.nagot.lastfm.model.Track;

import java.util.List;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface TrackFragmentMvpView extends BaseMvpView {

    void updateData(List<Track> trackList);
}
