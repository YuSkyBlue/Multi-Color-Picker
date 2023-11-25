package com.bluesky.multicolorpicker.listeners

import com.bluesky.multicolorpicker.ColorEnvelope

interface ColorListener {
    fun onColorSelected(envelope: ColorEnvelope)
}