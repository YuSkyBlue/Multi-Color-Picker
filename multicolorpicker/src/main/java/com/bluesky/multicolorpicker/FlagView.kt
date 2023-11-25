package com.bluesky.multicolorpicker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout

abstract class FlagView(context: Context, layout: Int) : RelativeLayout(context) {

    init {
        initializeLayout(layout)
    }

    private fun initializeLayout(layout: Int) {
        val inflated = LayoutInflater.from(context).inflate(layout, this)
        inflated.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        inflated.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        inflated.layout(0, 0, inflated.measuredWidth, inflated.measuredHeight)
    }

    fun visible() {
        visibility = View.VISIBLE
    }

    fun gone() {
        visibility = View.GONE
    }

    abstract fun onRefresh(envelope: ColorEnvelope)
}