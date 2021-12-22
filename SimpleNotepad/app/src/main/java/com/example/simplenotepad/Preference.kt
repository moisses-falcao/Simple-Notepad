package com.example.simplenotepad

import android.content.Context
import android.content.SharedPreferences

class Preference(private val context: Context) {

    private val ARCHIVE = "annotation.preference"
    private val KEY = "name"
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    fun SaveAnnotation(annotation: String?){
        editor.putString(KEY, annotation)
        editor.commit()
    }

    fun RecoverAnnotation(): String?{
        return preferences.getString(KEY, "")
    }

    init{
        preferences = context.getSharedPreferences(ARCHIVE, 0)
        editor = preferences.edit()
    }

}