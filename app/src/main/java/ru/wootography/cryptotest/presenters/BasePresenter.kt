package ru.wootography.cryptotest.presenters

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.wootography.cryptotest.api.RestApi
import ru.wootography.cryptotest.utils.presenter.TokenHelper


open class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    open val TAG = javaClass.simpleName

    private val compositeDisposable = CompositeDisposable()


    protected fun unSubscribeOnDestroy(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
