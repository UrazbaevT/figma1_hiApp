package com.example.figma.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {

    private val pref = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE)

    //getStartFragment
    fun isUserSee():Boolean{
        return pref.getBoolean(USER_SEEN, false)
    }

    fun saveSeen(){
        pref.edit().putBoolean(USER_SEEN, true).apply()
    }





    companion object{
        const val PREF_KEY = "pref_key"
        const val USER_SEEN = "get_start_key"
    }
}