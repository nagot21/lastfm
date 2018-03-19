package com.nagot.lastfm.ui.track;

import com.nagot.lastfm.data.retrofit.ServiceGenerator;
import com.nagot.lastfm.data.retrofit.service.TrackService;
import com.nagot.lastfm.model.Track;
import com.nagot.lastfm.model.TrackResponse;
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
 * Created by Nagot on 18/03/2018.
 */

public class TrackFragmentPresenter<V extends TrackFragmentMvpView>
        implements TrackFragmentMvpPresenter<V> {

    private TrackFragmentMvpView mView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void onAttach(V view) {
        this.mView = view;
    }

    @Override
    public void getTrack(String trackName) {
        disposeRequest();
        mView.showProgress();
        mView.hideEmpty();

        mCompositeDisposable.add(ServiceGenerator
                .createService(TrackService.class)
                .getTrack(trackName, ConstantsUtil.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TrackResponse, List<Track>>() {
                    @Override
                    public List<Track> apply(@NonNull TrackResponse trackResponse)
                            throws Exception {
                        if (trackResponse != null
                                && trackResponse.getResults().getTrackMatches() != null) {
                            return trackResponse.getResults().getTrackMatches().getTrackList();
                        } else {
                            return new ArrayList<>();
                        }
                    }
                })
                .subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(@NonNull List<Track> trackList)
                            throws Exception {
                        mView.hideProgress();
                        if (trackList.size() == 0) {
                            mView.showEmpty();
                        }
                        mView.updateData(trackList);
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
