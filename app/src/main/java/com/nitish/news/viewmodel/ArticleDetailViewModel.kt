package com.nitish.news.viewmodel

import androidx.lifecycle.ViewModel
import com.nitish.news.model.ArticlesItem
import com.nitish.news.repository.MainRepository
import io.realm.RealmResults
import javax.inject.Inject

class ArticleDetailViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    fun getArticleDetailItem(url: String): RealmResults<ArticlesItem> = mainRepository.getRepoItem(url)
}