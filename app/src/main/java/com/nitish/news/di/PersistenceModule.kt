package com.nitish.news.di

import com.nitish.news.db.LocalDb
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
class PersistenceModule {
    @Provides
    fun providesLocalRealmDB(realm: Realm?): LocalDb {
        return LocalDb(realm!!)
    }

    @Provides
    fun providesRealm(realmConfiguration: RealmConfiguration?): Realm {
        return Realm.getInstance(realmConfiguration)
    }

    @Provides
    @Singleton
    fun providesRealmConfiguration(): RealmConfiguration {
        val builder = RealmConfiguration.Builder()
        builder.deleteRealmIfMigrationNeeded()
        // builder.inMemory();
        return builder.build()
    }
}