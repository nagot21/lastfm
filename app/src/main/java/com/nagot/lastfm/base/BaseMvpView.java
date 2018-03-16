package com.nagot.lastfm.base;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface BaseMvpView {

    void showProgress();

    void hideProgress();

    void showError();

    void showEmpty();

    void hideEmpty();
}
