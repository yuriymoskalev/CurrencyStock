package ru.wootography.cryptotest.di.components

import javax.inject.Singleton

import dagger.Component
import ru.wootography.cryptotest.App
import ru.wootography.cryptotest.activities.BaseActivity
import ru.wootography.cryptotest.di.modules.ViewModule
import ru.wootography.cryptotest.fragments.BaseFragment


@Singleton
@Component(modules = arrayOf(ViewModule::class))
interface ViewComponent {
    fun inject(app: App)
    fun inject(baseFragment: BaseFragment)
    fun inject(baseActivity: BaseActivity)
}
