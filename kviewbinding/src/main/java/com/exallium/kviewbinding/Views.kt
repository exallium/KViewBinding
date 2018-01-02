package com.exallium.kviewbinding

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View

interface ViewBinder {
    fun <T> findViewById(@IdRes idRes: Int): T
}

fun <T : View> View.bindView(@IdRes idRes: Int): Lazy<T> = bindView(idRes, this::findViewById)
fun <T : View> Fragment.bindView(@IdRes idRes: Int): Lazy<T> = bindView(idRes) { this.view!!.findViewById<T>(idRes) }
fun <T : View> AppCompatActivity.bindView(@IdRes idRes: Int): Lazy<T> = bindView(idRes, this::findViewById)
fun <T : View> ViewBinder.bindView(@IdRes idRes: Int): Lazy<T> = bindView(idRes, this::findViewById)
fun <T : View> bindView(@IdRes idRes: Int, bindFn: BindResourceFn<Int, T>) = lazyBindResource(idRes, bindFn, LazyThreadSafetyMode.NONE)
