package com.baltsarak.airtickets.di

import android.content.Context
import com.baltsarak.airtickets.AirTicketsApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val application: AirTicketsApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext
}