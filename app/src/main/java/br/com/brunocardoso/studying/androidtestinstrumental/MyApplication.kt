package br.com.brunocardoso.studying.androidtestinstrumental

import android.app.Application

open class MyApplication : Application() {
    open fun getUrl() = BuildConfig.BASE_URL
}