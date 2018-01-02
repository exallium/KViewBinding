package com.exallium.kviewbinding

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.View

interface DrawableBinder {
    fun getDrawable(@DrawableRes drawableId: Int): Drawable
}

private fun getDrawable(context: Context, drawableRes: Int) = ContextCompat.getDrawable(context, drawableRes)

fun View.bindDrawable(@DrawableRes drawableRes: Int): Lazy<Drawable> = bindDrawable(drawableRes, { getDrawable(this.context, it)!! })
fun Fragment.bindDrawable(@DrawableRes drawableRes: Int): Lazy<Drawable> = bindDrawable(drawableRes, { getDrawable(this.context!!, it)!! })
fun Context.bindDrawable(@DrawableRes drawableRes: Int): Lazy<Drawable> = bindDrawable(drawableRes, { getDrawable(this, it)!! })
fun DrawableBinder.bindDrawable(@DrawableRes drawableRes: Int): Lazy<Drawable> = bindDrawable(drawableRes, this::getDrawable)
fun bindDrawable(@DrawableRes drawableRes: Int, bindFn: BindResourceFn<Int, Drawable>) = lazyBindResource(drawableRes, bindFn)
