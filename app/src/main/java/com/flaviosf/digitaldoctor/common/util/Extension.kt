package com.flaviosf.digitaldoctor.common.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.digitaldoctor.R

fun ImageView.load(with: Context, load: String, into: ImageView, ) {

    val requestOptions = RequestOptions()
        .placeholder(R.drawable.ic_logo)
        .error(R.drawable.ic_launcher_background)

    Glide.with(with)
        .applyDefaultRequestOptions(requestOptions)
        .load(load)
        .into(into)
}