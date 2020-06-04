package com.nitish.doubtnutassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.nitish.doubtnutassignment.model.ArticlesItem
import com.nitish.doubtnutassignment.repository.MainRepository
import io.realm.RealmResults
import javax.inject.Inject

class ArticleDetailViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    fun getArticleDetailItem(url: String): RealmResults<ArticlesItem> = mainRepository.getRepoItem(url)
}