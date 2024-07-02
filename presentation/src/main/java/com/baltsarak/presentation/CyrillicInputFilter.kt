package com.baltsarak.presentation

import android.text.InputFilter
import android.text.Spanned

class CyrillicInputFilter : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        if (source == null) return null

        val builder = StringBuilder()
        for (i in start until end) {
            val char = source[i]
            if (char in '\u0400'..'\u04FF' || char == ' ') {
                builder.append(char)
            }
        }
        return if (builder.isEmpty()) {
            ""
        } else {
            builder.toString()
        }
    }
}