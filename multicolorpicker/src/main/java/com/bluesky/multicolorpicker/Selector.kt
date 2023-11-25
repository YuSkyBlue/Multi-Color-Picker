package com.bluesky.multicolorpicker
import android.widget.ImageView
import com.bluesky.multicolorpicker.listeners.ColorListener
import com.bluesky.multicolorpicker.listeners.SelectorListener

class Selector(val selector: ImageView, val colorListener: ColorListener) {

    var x: Int = 0
        private set
    var y: Int = 0
        private set

    var color: Int = 0
    private var selectorListener: SelectorListener? = null

    val colorHtml: String
        get() = String.format("%06X", 0xFFFFFF and color)

    val colorRGB: IntArray
        get() {
            val rgb = IntArray(3)
            val color = java.lang.Long.parseLong(String.format("%06X", 0xFFFFFF and color), 16).toInt()
            rgb[0] = color shr 16 and 0xFF
            rgb[1] = color shr 8 and 0xFF
            rgb[2] = color shr 0 and 0xFF
            return rgb
        }

    fun setPoint(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun setSelectorListener(selectorListener: SelectorListener) {
        this.selectorListener = selectorListener
    }

    fun onMove(x: Int, y: Int) {
        selectorListener!!.onMove(this, x, y)
    }

    fun onMoveCenter() {
        selectorListener!!.onMoveCenter(this)
    }

    fun onSelect() {
        selectorListener!!.onSelect(this)
    }

    fun onSelect(x: Int, y: Int) {
        selectorListener!!.onSelect(this, x, y)
    }
}