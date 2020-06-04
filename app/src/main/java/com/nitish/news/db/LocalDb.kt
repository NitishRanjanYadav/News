package com.nitish.news.db

import com.nitish.news.model.ArticlesItem
import com.nitish.news.model.BaseModel
import io.realm.Realm
import io.realm.RealmResults

class LocalDb(var realm: Realm) {

    fun getRepoListDb(): RealmResults<ArticlesItem> {
        return realm.where(ArticlesItem::class.java).findAllAsync()
    }
    fun getRepoItemDb(url: String): RealmResults<ArticlesItem> {
        return realm.where(ArticlesItem::class.java).equalTo("url", url).findAllAsync()
    }

    fun saveRepos(baseModel : BaseModel) {
        realm.executeTransactionAsync { realm: Realm ->
            realm.copyToRealmOrUpdate(baseModel.articles)
        }
    }
}