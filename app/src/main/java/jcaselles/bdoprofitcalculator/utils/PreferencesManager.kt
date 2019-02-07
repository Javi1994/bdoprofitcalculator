package jcaselles.bdoprofitcalculator.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(app: Application) {
    private val prefsName = "BDOProfitCalculator_preferences"

    private val sharedPreferences: SharedPreferences
    private val gson: Gson = Gson()

    init {
        sharedPreferences = app.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    }
}