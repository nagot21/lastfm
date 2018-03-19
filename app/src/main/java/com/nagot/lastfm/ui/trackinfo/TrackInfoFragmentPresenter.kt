package com.nagot.lastfm.ui.trackinfo

import com.nagot.lastfm.data.retrofit.ServiceGenerator
import com.nagot.lastfm.data.retrofit.service.TrackService
import com.nagot.lastfm.utils.ConstantsUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Nagot on 18/03/2018.
 */
class TrackInfoFragmentPresenter<V : TrackInfoFragmentMvpView> : TrackInfoFragmentMvpPresenter<V> {

    private lateinit var mView: TrackInfoFragmentMvpView
    private val mCompositeDisposable = CompositeDisposable()

    override fun onAttach(view: V) {
        this.mView = view
    }

    override fun onDetach() {
        mView //TODO: FIX
    }

    override fun getTrackInfo(trackName: String, artistName: String) {
        disposeRequest()
        mView.showProgress()
        mView.hideEmpty()

        mCompositeDisposable.add(ServiceGenerator
                .createService(TrackService::class.java)
                .getTrackInfo(trackName, artistName, ConstantsUtil.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.trackInfo }
                .subscribe({ trackInfo ->
                    mView.hideProgress()
                    mView.updateData(trackInfo)
                }, { mView.showError() }))
    }

    private fun disposeRequest() {
        if (!mCompositeDisposable.isDisposed) {
            mCompositeDisposable.clear()
        }
    }
}