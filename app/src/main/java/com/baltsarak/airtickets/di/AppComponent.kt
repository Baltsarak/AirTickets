package com.baltsarak.airtickets.di

import com.baltsarak.airtickets.AirTicketsApp
import com.baltsarak.data.di.DataModule
import com.baltsarak.data.di.NetworkModule
import com.baltsarak.presentation.di.ActivityModule
import com.baltsarak.presentation.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        ActivityModule::class]
)
interface AppComponent : AndroidInjector<AirTicketsApp> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: AirTicketsApp,
            appModule: AppModule
        ): AppComponent
    }
}