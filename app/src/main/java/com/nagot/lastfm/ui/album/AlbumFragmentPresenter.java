package com.nagot.lastfm.ui.album;

import com.nagot.lastfm.data.retrofit.ServiceGenerator;
import com.nagot.lastfm.data.retrofit.service.AlbumService;
import com.nagot.lastfm.model.Album;
import com.nagot.lastfm.model.AlbumResponse;
import com.nagot.lastfm.utils.ConstantsUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Nagot on 17/03/2018.
 */

public class AlbumFragmentPresenter<V extends AlbumFragmentMvpView>
        implements AlbumFragmentMvpPresenter<V> {

    private AlbumFragmentMvpView mView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void onAttach(V view) {
        this.mView = view;
    }

    @Override
    public void getAlbum(String albumName) {
        disposeRequest();
        mView.showProgress();
        mView.hideEmpty();

        mCompositeDisposable.add(ServiceGenerator
                .createService(AlbumService.class)
                .getAlbum(albumName, ConstantsUtil.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<AlbumResponse, List<Album>>() {
                    @Override
                    public List<Album> apply(@NonNull AlbumResponse albumResponse)
                            throws Exception {
                        if (albumResponse != null
                                && albumResponse.getResults().getAlbumMatches() != null) {
                            return albumResponse.getResults().getAlbumMatches().getAlbumList();
                        } else {
                            return new ArrayList<>();
                        }
                    }
                })
                .subscribe(new Consumer<List<Album>>() {
                    @Override
                    public void accept(@NonNull List<Album> albumList)
                            throws Exception {
                        mView.hideProgress();
                        if (albumList.size() == 0) {
                            mView.showEmpty();
                        }
                        mView.updateData(albumList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable)
                            throws Exception {
                        mView.showError();
                    }
                }));
    }

    private void disposeRequest() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.clear();
        }
    }
}
