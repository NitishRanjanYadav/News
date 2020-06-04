package com.nitish.news.di

import com.nitish.news.MainActivity
import com.nitish.news.NewsDetailActivity
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: NewsDetailActivity)
}