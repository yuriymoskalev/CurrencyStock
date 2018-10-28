package ru.wootography.cryptotest.utils.presenter

import android.support.annotation.ArrayRes
import android.support.annotation.StringRes

import ru.wootography.cryptotest.App

class Resources(private val app: App) {

    fun getString(@StringRes resId: Int): String {
        return app.getString(resId)
    }

    fun getStringArray(@ArrayRes resId: Int): Array<String> {
        return app.resources.getStringArray(resId)
    }

}
