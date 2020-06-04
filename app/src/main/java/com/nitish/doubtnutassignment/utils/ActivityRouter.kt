package com.nitish.doubtnutassignment.utils

import android.app.Activity
import android.content.Intent
import com.nitish.doubtnutassignment.NewsDetailActivity
import com.nitish.doubtnutassignment.model.ArticlesItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityRouter @Inject constructor(private val activity: Activity) {
    fun startNewsDetailActivity(articlesItem: ArticlesItem) {
        val intent = Intent(activity, NewsDetailActivity::class.java)
        intent.putExtra(NewsDetailActivity.KEY_DATA, articlesItem.url)
        activity.startActivity(intent)
    }
}