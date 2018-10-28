package ru.wootography.cryptotest.activities

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.View

import com.arellomobile.mvp.MvpAppCompatActivity

import javax.inject.Inject

import ru.wootography.cryptotest.R
import ru.wootography.cryptotest.interfaces.utils_view.BaseLifeCycle
import ru.wootography.cryptotest.interfaces.utils_view.NavigatorActivityView
import ru.wootography.cryptotest.utils.AnimationHelper
import ru.wootography.cryptotest.utils.Injector
import ru.wootography.cryptotest.utils.KeyboardHelper
import ru.wootography.cryptotest.utils.Navigator


abstract class BaseActivity : MvpAppCompatActivity(), NavigatorActivityView, BaseLifeCycle {

    open val TAG = javaClass.simpleName

    @Inject
    protected lateinit var animationHelper: AnimationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.viewComponent?.inject(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }


    protected fun hideKeyboard() {
        KeyboardHelper.hide(this)
    }

    protected fun hideView(view: View) {
        if (view.visibility == View.VISIBLE) {
            view.visibility = View.GONE
        }
    }

    protected fun showView(view: View) {
        if (view.visibility == View.GONE) {
            view.visibility = View.VISIBLE
        }
    }

    override fun startActivity(activityClass: Class<out BaseActivity>) {
        Navigator.startActivity(this, activityClass, false)
    }

    override fun startActivityForResult(activityClass: Class<out BaseActivity>, requestCode: Int) {
        Navigator.startActivityForResult(this, activityClass, requestCode)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }


    @SuppressWarnings("unchecked")
    protected fun <T : View> bindView(@IdRes id: Int): T {
        return findViewById(id)
    }


    protected fun bindColor(@ColorRes id: Int): Int {
        return ContextCompat.getColor(this, id)
    }


    protected fun bindString(@StringRes id: Int): String {
        return getString(id)
    }

    protected fun bindDimen(@DimenRes id: Int): Int {
        return resources.getDimension(id).toInt()
    }

}
