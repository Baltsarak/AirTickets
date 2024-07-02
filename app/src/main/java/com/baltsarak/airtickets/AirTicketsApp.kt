package com.baltsarak.airtickets

import com.baltsarak.airtickets.di.AppModule
import com.baltsarak.airtickets.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AirTicketsApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this, AppModule(this))
    }
}