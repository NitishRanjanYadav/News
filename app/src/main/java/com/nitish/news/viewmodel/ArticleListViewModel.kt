package com.nitish.news.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.nitish.news.model.ArticlesItem
import com.nitish.news.model.BaseModel
import com.nitish.news.repository.MainRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.realm.RealmResults
import javax.inject.Inject

class ArticleListViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {
    var repos: RealmResults<ArticlesItem>? = null
        private set
    private val hasMore = true
    private val page: ObservableField<Int>
    val showError: ObservableField<Boolean>
    val isLoading: ObservableField<Boolean>
    val repo: Unit
        get() {
            repos = mainRepository.getRepoList()
        }


    fun loadForPage(requestedPage: Int) {
        if (!isLoading.get()!!) {
            isLoading.set(true)
            showError.set(false)
            mainRepository.fetchAndPersistRepos(requestedPage)
                .subscribe(object : Observer<BaseModel> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(baseModel : BaseModel) { // hasMore = products.size() == 10;
                    }

                    override fun onError(e: Throwable) {
                        isLoading.set(false)
                        if (repos!!.size == 0) {
                            showError.set(true)
                        }
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                        isLoading.set(false)
                        page.set(requestedPage)
                    }
                })
        }
    }

    fun getPage(): Int {
        return page.get()!!
    }

    fun hasMore(): Boolean {
        return hasMore
    }

    init {
        page = ObservableField(1)
        showError = ObservableField(false)
        isLoading = ObservableField(false)
    }
}