package com.nitish.news.di

import android.app.Application
import android.content.Context
import com.nitish.news.network.NetworkModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, PersistenceModule::class])
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return app
    }

    @Provides
    @Singleton
    @AppContext
    fun providesContext(): Context {
        return app
    }

}