package ru.wootography.cryptotest.di.modules

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import ru.wootography.cryptotest.App
import ru.wootography.cryptotest.utils.AnimationHelper


@Module
class ViewModule(app: App) {


    private val animationHelper: AnimationHelper = AnimationHelper(app)

    @Provides
    @Singleton
    internal fun provideAnimationHelper(): AnimationHelper {
        return animationHelper
    }
}
