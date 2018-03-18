package com.nagot.lastfm.ui.album;

import com.nagot.lastfm.base.BaseMvpView;
import com.nagot.lastfm.model.Album;

import java.util.List;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface AlbumFragmentMvpView extends BaseMvpView {

    void updateData(List<Album> albumList);
}
