package com.nitish.doubtnutassignment.di

import android.app.Application
import android.content.Context
import com.nitish.doubtnutassignment.network.NetworkModule
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