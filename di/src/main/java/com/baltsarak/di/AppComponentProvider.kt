package com.baltsarak.di

import com.baltsarak.airtickets.di.AppComponent

interface AppComponentProvider {
    fun getAppComponent(): AppComponent
}