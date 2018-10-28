package ru.wootography.cryptotest.interfaces.utils_view

import ru.wootography.cryptotest.interfaces.views.BaseView

interface NetworkView : BaseView {
    fun showProgress(show: Boolean)
    fun showData(show: Boolean)
    fun showError(show: Boolean, text: String)
}
