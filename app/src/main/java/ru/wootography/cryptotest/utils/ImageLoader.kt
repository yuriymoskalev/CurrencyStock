package ru.wootography.cryptotest.utils

import android.content.Context
import android.widget.ImageView

import com.bumptech.glide.Glide
object ImageLoader {
    //@formatter:on


    fun load(context: Context, imageView: ImageView, url: String) {
        Glide.with(context)
                .load(url)
                .into(imageView)
        // TODO: 11.09.2018 PlaceHolder here and any logic

    }

}//@formatter:off
