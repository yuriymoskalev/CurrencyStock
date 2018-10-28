package ru.wootography.cryptotest.presenters

import com.arellomobile.mvp.InjectViewState

import javax.inject.Inject

import ru.wootography.cryptotest.activities.MainActivity
import ru.wootography.cryptotest.api.RestApi
import ru.wootography.cryptotest.interfaces.views.SplashView
import ru.wootography.cryptotest.utils.presenter.TokenHelper


@InjectViewState
class SplashPresenter @Inject
internal constructor(private val restApi: RestApi,
                     private val tokenHelper: TokenHelper
                    ) : BasePresenter<SplashView>() {

    init {
        startNext()
    }


    fun startNext() {
        viewState.showErrorConnection(false)
        if (tokenHelper!!.isFirstRun) {
            viewState.startActivity(MainActivity::class.java)
        }
    }

}
