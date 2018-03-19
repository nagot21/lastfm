package com.nagot.lastfm.base;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void onAttach(V view);

}
