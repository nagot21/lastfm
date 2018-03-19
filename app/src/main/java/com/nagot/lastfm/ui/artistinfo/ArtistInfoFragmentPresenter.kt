package com.nagot.lastfm.ui.artistinfo

import com.nagot.lastfm.data.retrofit.ServiceGenerator
import com.nagot.lastfm.data.retrofit.service.ArtistService
import com.nagot.lastfm.model.Artist
import com.nagot.lastfm.model.ArtistInfo
import com.nagot.lastfm.model.ArtistInfoResponse
import com.nagot.lastfm.utils.ConstantsUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Nagot on 18/03/2018.
 */
class ArtistInfoFragmentPresenter<V : ArtistInfoFragmentMvpView> : ArtistInfoFragmentMvpPresenter<V> {

    private lateinit var mView: ArtistInfoFragmentMvpView
    private val mCompositeDisposable = CompositeDisposable()

    override fun onAttach(view: V) {
        this.mView = view
    }

    override fun getArtistInfo(artistName: String) {
        disposeRequest()
        mView.showProgress()
        mView.hideEmpty()

        mCompositeDisposable.add(ServiceGenerator
                .createService(ArtistService::class.java)
                .getArtistInfo(artistName, ConstantsUtil.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.artistInfo }
                .subscribe({ artistInfo ->
                    mView.hideProgress()
                    mView.updateData(artistInfo)
                }, { mView.showError() }))
    }

    private fun disposeRequest() {
        if (!mCompositeDisposable.isDisposed) {
            mCompositeDisposable.clear()
        }
    }
}