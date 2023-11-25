package com.bluesky.multi_colorpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bluesky.multi_colorpicker.databinding.ActivityMainBinding
import com.bluesky.multicolorpicker.ColorEnvelope
import com.bluesky.multicolorpicker.listeners.ColorListener



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.multiColorPickerView.setSelectedAlpha(0.6f)
        binding.multiColorPickerView.setPaletteDrawable(ContextCompat.getDrawable(this, R.drawable.watercolor1)!!)
        binding.multiColorPickerView.addSelector(ContextCompat.getDrawable(this, R.drawable.wheel), colorListener0)
        binding.multiColorPickerView.addSelector(ContextCompat.getDrawable(this, R.drawable.wheel), colorListener1)
        binding.multiColorPickerView.addSelector(ContextCompat.getDrawable(this, R.drawable.wheel), colorListener2)
        binding.multiColorPickerView.addSelector(ContextCompat.getDrawable(this, R.drawable.wheel), colorListener3)
        binding.multiColorPickerView.setFlagView(CustomFlag(this, R.layout.layout_flag))
    }

    private val colorListener0 = object: ColorListener {
        override fun onColorSelected(envelope: ColorEnvelope) {
            binding.textView0.text = "#${envelope.htmlCode}"
            binding.linearLayout0.setBackgroundColor(envelope.color)
        }
    }

    private val colorListener1 = object: ColorListener {
        override fun onColorSelected(envelope: ColorEnvelope) {
            binding.textView1.text = "#${envelope.htmlCode}"
            binding.linearLayout1.setBackgroundColor(envelope.color)
        }
    }

    private val colorListener2 = object: ColorListener {
        override fun onColorSelected(envelope: ColorEnvelope) {
            binding.textView2.text = "#${envelope.htmlCode}"
            binding.linearLayout2.setBackgroundColor(envelope.color)
        }
    }

    private val colorListener3 = object: ColorListener {
        override fun onColorSelected(envelope: ColorEnvelope) {
            binding.textView3.text = "#${envelope.htmlCode}"
            binding.linearLayout3.setBackgroundColor(envelope.color)
        }
    }
}