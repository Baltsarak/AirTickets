package com.baltsarak.airtickets

import com.baltsarak.airtickets.di.AppModule
import com.baltsarak.airtickets.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AirTicketsApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this, AppModule(this))
    }
}