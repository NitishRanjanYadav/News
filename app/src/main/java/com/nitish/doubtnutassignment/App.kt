package com.nitish.doubtnutassignment

import android.app.Application
import android.content.Context
import com.nitish.doubtnutassignment.di.AppComponent
import com.nitish.doubtnutassignment.di.AppModule
import com.nitish.doubtnutassignment.di.DaggerAppComponent
import com.nitish.doubtnutassignment.di.PersistenceModule
import com.nitish.doubtnutassignment.network.NetworkModule
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