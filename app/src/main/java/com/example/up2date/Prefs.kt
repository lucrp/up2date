package com.example.up2date

import android.content.Context

class Prefs(context: Context, PREFS_NAME: String) {
    val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

}