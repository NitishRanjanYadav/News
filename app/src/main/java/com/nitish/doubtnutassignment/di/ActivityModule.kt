package com.nitish.doubtnutassignment.di

import android.app.Activity
import com.nitish.doubtnutassignment.utils.ActivityRouter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providesActivityRouter(): ActivityRouter {
        return ActivityRouter(activity)
    }

}