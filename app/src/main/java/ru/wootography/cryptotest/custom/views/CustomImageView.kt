package ru.wootography.cryptotest.custom.views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

import ru.wootography.cryptotest.utils.ImageLoader


class CustomImageView : ImageView {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    fun load(URL: String) {
        ImageLoader.load(context, this, URL)
    }


}
