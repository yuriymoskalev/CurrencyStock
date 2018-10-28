package ru.wootography.cryptotest.di.modules

import android.preference.PreferenceManager

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import ru.wootography.cryptotest.App
import ru.wootography.cryptotest.api.RestApi
import ru.wootography.cryptotest.utils.presenter.TokenHelper


@Module
class RestModule(app: App) {

    private val tokenHelper: TokenHelper = TokenHelper(PreferenceManager.getDefaultSharedPreferences(app))
    private val restApi: RestApi

    init {
        restApi = RestApi(tokenHelper)
    }


    @Singleton
    @Provides
    internal fun provideRestApi(): RestApi {
        return restApi
    }

    @Singleton
    @Provides
    internal fun provideTokenHelper(): TokenHelper {
        return tokenHelper
    }
}

