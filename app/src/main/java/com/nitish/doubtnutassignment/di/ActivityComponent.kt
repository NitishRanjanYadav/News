package com.nitish.doubtnutassignment.di

import com.nitish.doubtnutassignment.MainActivity
import com.nitish.doubtnutassignment.NewsDetailActivity
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: NewsDetailActivity)
}