package com.nitish.news.di

import com.nitish.news.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
    fun plusActivityModule(activityModule: ActivityModule): ActivityComponent
}