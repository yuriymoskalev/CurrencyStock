package ru.wootography.cryptotest.interfaces.utils_view

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

import ru.wootography.cryptotest.activities.BaseActivity
import ru.wootography.cryptotest.interfaces.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface NavigatorActivityView : BaseView {
    fun startActivity(activityClass: Class<out BaseActivity>)
    fun startActivityForResult(activityClass: Class<out BaseActivity>, requestCode: Int)
}
