package ru.wootography.cryptotest.di.modules

import dagger.Module
import dagger.Provides
import ru.wootography.cryptotest.App
import ru.wootography.cryptotest.utils.presenter.Resources


@Module
class UtilsModule(private val app: App) {

    @Provides
    internal fun provideResources(): Resources {
        return Resources(app)
    }

}
