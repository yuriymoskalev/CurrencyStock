package ru.wootography.cryptotest


import android.app.Application
import ru.wootography.cryptotest.di.components.DaggerPresenterComponent
import ru.wootography.cryptotest.di.components.DaggerViewComponent
import ru.wootography.cryptotest.di.modules.RestModule
import ru.wootography.cryptotest.di.modules.UtilsModule
import ru.wootography.cryptotest.di.modules.ViewModule
import ru.wootography.cryptotest.utils.Injector



class App : Application() {


    override fun onCreate() {
        super.onCreate()
        setupDagger2()
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
    }

    private fun setupDagger2() {
        val presenterComponent = DaggerPresenterComponent.builder()
                .restModule(RestModule(this))
                .utilsModule(UtilsModule(this))
                .build()
        presenterComponent.inject(this)

        val viewComponent = DaggerViewComponent.builder()
                .viewModule(ViewModule(this))
                .build()
        viewComponent.inject(this)

        Injector.presenterComponent = presenterComponent
        Injector.viewComponent = viewComponent
    }


}
