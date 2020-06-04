package com.nitish.doubtnutassignment.repository

import com.nitish.doubtnutassignment.db.LocalDb
import com.nitish.doubtnutassignment.model.ArticlesItem
import com.nitish.doubtnutassignment.model.BaseModel
import com.nitish.doubtnutassignment.network.APIService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import io.realm.RealmResults
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(db: LocalDb, apiService: APIService) {
    private val db: LocalDb
    private val apiService: APIService

    fun getRepoList() : RealmResults<ArticlesItem> = db.getRepoListDb()

    fun getRepoItem(url: String): RealmResults<ArticlesItem> = db.getRepoItemDb(url)

    fun fetchAndPersistRepos(page: Int): Observable<BaseModel> {
        return apiService.getNewsList("us", "7c940d1c674c41a7b135c2b68137d9f8")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map(object :
                Function<BaseModel, BaseModel> {
                @Throws(Exception::class)
                override fun apply(baseResponseList: BaseModel): BaseModel {
                    return baseResponseList
                }
            })
            .doOnNext(Consumer<BaseModel> { repoModelList -> db.saveRepos(repoModelList) })
    }

    init {
        this.db = db
        this.apiService = apiService
    }
}