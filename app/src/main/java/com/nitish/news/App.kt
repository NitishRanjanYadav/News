package com.nitish.news

import android.app.Application
import com.nitish.news.di.AppComponent
import com.nitish.news.di.AppModule
import com.nitish.news.di.DaggerAppComponent
import com.nitish.news.di.PersistenceModule
import com.nitish.news.network.NetworkModule
import io.realm.Realm


class App : Application() {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        component.inject(this)
    }

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .persistenceModule(PersistenceModule())
            .build()
    }
}