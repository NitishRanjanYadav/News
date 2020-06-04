package com.nitish.doubtnutassignment

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nitish.doubtnutassignment.databinding.ActivityNewsDetailBinding
import com.nitish.doubtnutassignment.di.ActivityModule
import com.nitish.doubtnutassignment.viewmodel.ArticleDetailViewModel
import javax.inject.Inject

class NewsDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewmodel : ArticleDetailViewModel
    val Activity.app: App get() = application as App
    val component by lazy { app.component.plusActivityModule(ActivityModule(this)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityNewsDetailBinding>(this, R.layout.activity_news_detail)
        component.inject(this)
        val data = viewmodel.getArticleDetailItem(intent.getStringExtra(KEY_DATA))
        dataBinding.vm =data.get(0)
        setSupportActionBar(dataBinding.toolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        dataBinding.collapsibleToolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    companion object {
        @JvmField
        var KEY_DATA: String = "news_data"
    }
}
