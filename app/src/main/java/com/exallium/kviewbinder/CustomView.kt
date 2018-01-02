package com.exallium.kviewbinder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.exallium.kviewbinding.bindColor
import com.exallium.kviewbinding.bindDimen
import com.exallium.kviewbinding.bindDimenPixelOffset
import com.exallium.kviewbinding.bindDimenPixelSize
import com.exallium.kviewbinding.bindDrawable
import com.exallium.kviewbinding.bindString
import com.exallium.kviewbinding.bindText
import com.exallium.kviewbinding.bindView

class CustomView(context: Context) : ViewGroup(context) {

    val textView: TextView by bindView(R.id.custom_view_text_view)
    val nullView: TextView by bindView(R.id.text)
    val color by bindColor(R.color.colorAccent)
    val dimen by bindDimen(R.dimen.test_dimen)
    val dimenOffset by bindDimenPixelOffset(R.dimen.test_dimen)
    val dimenSize by bindDimenPixelSize(R.dimen.test_dimen)
    val drawable by bindDrawable(R.drawable.ic_launcher_background)
    val str by bindString(R.string.app_name)
    val formatStr by bindString(R.string.fmt, "asdf")
    val text by bindText(R.string.app_name)

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}