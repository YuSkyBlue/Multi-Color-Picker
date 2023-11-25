package com.bluesky.multicolorpicker.listeners

import com.bluesky.multicolorpicker.Selector

interface SelectorListener {
    fun onMove(selector: Selector, x: Int, y: Int)
    fun onMoveCenter(selector: Selector)
    fun onSelect(selector: Selector)
    fun onSelect(selector: Selector, x: Int, y: Int)
}