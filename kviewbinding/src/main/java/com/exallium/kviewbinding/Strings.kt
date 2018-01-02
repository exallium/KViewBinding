package com.exallium.kviewbinding

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View

interface StringBinder {
    fun getString(@StringRes stringId: Int): String
}

interface TextBinder {
    fun getText(@StringRes stringId: Int): CharSequence
}

interface FormatStringBinder {
    fun getString(@StringRes stringId: Int, vararg formatArgs: Any): String
}

fun View.bindString(@StringRes stringRes: Int): Lazy<String> = bindString(stringRes, bindFn = { this.context.resources.getString(it) })
fun Fragment.bindString(@StringRes stringRes: Int): Lazy<String> = bindString(stringRes, bindFn = { this.context.resources.getString(it) })
fun Context.bindString(@StringRes stringRes: Int): Lazy<String> = bindString(stringRes, bindFn = { this.resources.getString(it) })
fun StringBinder.bindString(@StringRes stringRes: Int): Lazy<String> = bindString(stringRes, bindFn = this::getString)
fun bindString(@StringRes stringRes: Int, bindFn: BindResourceFn<Int, String>) = lazyBindResource(stringRes, bindFn)

fun View.bindText(@StringRes stringRes: Int): Lazy<CharSequence> = bindText(stringRes, { this.context.resources.getText(it) })
fun Fragment.bindText(@StringRes stringRes: Int): Lazy<CharSequence> = bindText(stringRes, { this.context.resources.getText(it) })
fun Context.bindText(@StringRes stringRes: Int): Lazy<CharSequence> = bindText(stringRes, { this.resources.getText(it) })
fun TextBinder.bindText(@StringRes stringRes: Int): Lazy<CharSequence> = bindText(stringRes, this::getText)
fun bindText(@StringRes stringRes: Int, bindFn: BindResourceFn<Int, CharSequence>) = lazyBindResource(stringRes, bindFn)

fun View.bindString(@StringRes stringRes: Int, vararg formatArgs: Any): Lazy<String> = bindString(stringRes, bindFn = { this.context.resources.getString(it, formatArgs) })
fun Fragment.bindString(@StringRes stringRes: Int, vararg formatArgs: Any): Lazy<String> = bindString(stringRes, bindFn = { this.context.resources.getString(it, formatArgs) })
fun Context.bindString(@StringRes stringRes: Int, vararg formatArgs: Any): Lazy<String> = bindString(stringRes, bindFn = { this.resources.getString(it, formatArgs) })
fun FormatStringBinder.bindString(@StringRes stringRes: Int, vararg formatArgs: Any): Lazy<String> = bindString(stringRes, bindFn = { this.getString(it, formatArgs) })
