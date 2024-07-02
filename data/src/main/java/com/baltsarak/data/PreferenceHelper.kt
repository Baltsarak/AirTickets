package com.baltsarak.data

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)

    companion object {
        private const val PREFERENCES_FILE_KEY = "com.baltsarak.airtickets.PREFERENCE_FILE_KEY"
        private const val KEY_SAVED_TEXT = "saved_text"
    }

    fun saveText(text: String) {
        with(sharedPreferences.edit()) {
            putString(KEY_SAVED_TEXT, text)
            apply()
        }
    }

    fun loadText(): String? {
        return sharedPreferences.getString(KEY_SAVED_TEXT, "")
    }
}