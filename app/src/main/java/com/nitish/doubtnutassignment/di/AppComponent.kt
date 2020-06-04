package com.nitish.doubtnutassignment.di

import android.app.Application
import com.nitish.doubtnutassignment.App
import com.nitish.doubtnutassignment.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
    fun plusActivityModule(activityModule: ActivityModule): ActivityComponent
}