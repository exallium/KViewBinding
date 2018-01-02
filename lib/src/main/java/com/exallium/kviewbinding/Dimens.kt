package com.exallium.kviewbinding

import android.content.Context
import android.support.annotation.DimenRes
import android.support.v4.app.Fragment
import android.view.View

interface DimenBinder {
    fun getDimen(@DimenRes dimenId: Int): Float
}

interface DimenPixelOffsetBinder {
    fun getDimenPixelOffset(@DimenRes dimenId: Int): Int
}

interface DimenPixelSizeBinder {
    fun getDimenPixelSize(@DimenRes dimenId: Int): Int
}

fun View.bindDimen(@DimenRes dimenRes: Int): Lazy<Float> = bindDimen(dimenRes, { this.context.resources.getDimension(it) })
fun Fragment.bindDimen(@DimenRes dimenRes: Int): Lazy<Float> = bindDimen(dimenRes, { this.context.resources.getDimension(it) })
fun Context.bindDimen(@DimenRes dimenRes: Int): Lazy<Float> = bindDimen(dimenRes, { this.resources.getDimension(it) })
fun DimenBinder.bindDimen(@DimenRes dimenRes: Int): Lazy<Float> = bindDimen(dimenRes, this::getDimen)
fun bindDimen(@DimenRes dimenRes: Int, bindFn: BindResourceFn<Int, Float>) = lazyBindResource(dimenRes, bindFn)

fun View.bindDimenPixelOffset(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelOffset(dimenRes, { this.context.resources.getDimensionPixelOffset(it) })
fun Fragment.bindDimenPixelOffset(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelOffset(dimenRes, { this.context.resources.getDimensionPixelOffset(it) })
fun Context.bindDimenPixelOffset(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelOffset(dimenRes, { this.resources.getDimensionPixelOffset(it) })
fun DimenPixelOffsetBinder.bindDimenPixelOffset(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelOffset(dimenRes, this::getDimenPixelOffset)
fun bindDimenPixelOffset(@DimenRes dimenRes: Int, bindFn: BindResourceFn<Int, Int>) = lazyBindResource(dimenRes, bindFn)

fun View.bindDimenPixelSize(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelSize(dimenRes, { this.context.resources.getDimensionPixelSize(it) })
fun Fragment.bindDimenPixelSize(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelSize(dimenRes, { this.context.resources.getDimensionPixelSize(it) })
fun Context.bindDimenPixelSize(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelSize(dimenRes, { this.resources.getDimensionPixelSize(it) })
fun DimenPixelSizeBinder.bindDimenPixelSize(@DimenRes dimenRes: Int): Lazy<Int> = bindDimenPixelOffset(dimenRes, this::getDimenPixelSize)
fun bindDimenPixelSize(@DimenRes dimenRes: Int, bindFn: BindResourceFn<Int, Int>) = lazyBindResource(dimenRes, bindFn)
