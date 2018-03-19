package com.nagot.lastfm.ui.artist;

import com.nagot.lastfm.data.retrofit.ServiceGenerator;
import com.nagot.lastfm.data.retrofit.service.ArtistService;
import com.nagot.lastfm.model.Artist;
import com.nagot.lastfm.model.ArtistResponse;
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
 * Created by IanNagot on 16/03/2018.
 */

public class ArtistFragmentPresenter<V extends ArtistFragmentMvpView>
        implements ArtistFragmentMvpPresenter<V> {

    private ArtistFragmentMvpView mView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void onAttach(V view) {
        this.mView = view;
    }

    @Override
    public void getArtist(String artistName) {
        disposeRequest();
        mView.showProgress();
        mView.hideEmpty();

        mCompositeDisposable.add(ServiceGenerator
                .createService(ArtistService.class)
                .getArtists(artistName, ConstantsUtil.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ArtistResponse, List<Artist>>() {
                    @Override
                    public List<Artist> apply(@NonNull ArtistResponse artistResponse)
                            throws Exception {
                        if (artistResponse != null
                                && artistResponse.getResults().getArtistMatches() != null) {
                            return artistResponse.getResults().getArtistMatches().getArtistList();
                        } else {
                            return new ArrayList<>();
                        }
                    }
                })
                .subscribe(new Consumer<List<Artist>>() {
                    @Override
                    public void accept(@NonNull List<Artist> artistList)
                            throws Exception {
                        mView.hideProgress();
                        if (artistList.size() == 0) {
                            mView.showEmpty();
                        }
                        mView.updateData(artistList);
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
