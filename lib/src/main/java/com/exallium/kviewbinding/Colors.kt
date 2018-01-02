package com.exallium.kviewbinding

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.View

interface ColorBinder {
    @ColorInt fun getColor(@ColorRes colorId: Int): Int
}

private fun getColor(context: Context, colorRes: Int) = ContextCompat.getColor(context, colorRes)

fun View.bindColor(@ColorRes colorRes: Int): Lazy<Int> = bindColor(colorRes, { getColor(this.context, it) })
fun Fragment.bindColor(@ColorRes colorRes: Int): Lazy<Int> = bindColor(colorRes, { getColor(this.context, it) })
fun Context.bindColor(@ColorRes colorRes: Int): Lazy<Int> = bindColor(colorRes, { getColor(this, it) })
fun ColorBinder.bindColor(@ColorRes colorRes: Int): Lazy<Int> = bindColor(colorRes, this::getColor)
fun bindColor(@ColorRes colorRes: Int, bindFn: BindResourceFn<Int, Int>) = lazyBindResource(colorRes, bindFn)
