package ru.wootography.cryptotest.di.components

import javax.inject.Singleton

import dagger.Component
import ru.wootography.cryptotest.App
import ru.wootography.cryptotest.di.modules.RestModule
import ru.wootography.cryptotest.di.modules.UtilsModule
import ru.wootography.cryptotest.presenters.MainActivityPresenter
import ru.wootography.cryptotest.presenters.SplashPresenter


@Singleton
@Component(modules = arrayOf(RestModule::class, UtilsModule::class))
interface PresenterComponent {
    //@formatter:off
    fun inject(app: App)

    val mainActivityPresenter: MainActivityPresenter
    val splashPresenter: SplashPresenter
}
