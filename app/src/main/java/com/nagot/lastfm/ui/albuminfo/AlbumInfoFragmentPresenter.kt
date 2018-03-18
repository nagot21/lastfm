package com.nagot.lastfm.ui.albuminfo

import com.nagot.lastfm.data.retrofit.ServiceGenerator
import com.nagot.lastfm.data.retrofit.service.AlbumService
import com.nagot.lastfm.utils.ConstantsUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Nagot on 18/03/2018.
 */
class AlbumInfoFragmentPresenter<V : AlbumInfoFragmentMvpView> : AlbumInfoFragmentMvpPresenter<V> {

    private lateinit var mView: AlbumInfoFragmentMvpView
    private val mCompositeDisposable = CompositeDisposable()

    override fun onAttach(view: V) {
        this.mView = view
    }

    override fun onDetach() {
        mView //TODO: FIX
    }

    override fun getAlbumInfo(albumName: String, artistName: String) {
        disposeRequest()
        mView.showProgress()
        mView.hideEmpty()

        mCompositeDisposable.add(ServiceGenerator
                .createService(AlbumService::class.java)
                .getAlbumInfo(albumName, artistName, ConstantsUtil.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.albumInfo }
                .subscribe({ albumInfo ->
                    mView.hideProgress()
                    mView.updateData(albumInfo)
                }, { mView.showError() }))
    }

    private fun disposeRequest() {
        if (!mCompositeDisposable.isDisposed) {
            mCompositeDisposable.clear()
        }
    }
}