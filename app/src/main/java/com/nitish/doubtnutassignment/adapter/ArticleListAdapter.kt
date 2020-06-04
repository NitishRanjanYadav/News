package com.nitish.doubtnutassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nitish.doubtnutassignment.R
import com.nitish.doubtnutassignment.adapter.ArticleListAdapter.ItemViewHolder
import com.nitish.doubtnutassignment.databinding.ItemArticleBinding
import com.nitish.doubtnutassignment.model.ArticlesItem
import com.nitish.doubtnutassignment.utils.ActivityRouter
import com.nitish.doubtnutassignment.viewmodel.ArticleItemViewModel
import io.realm.RealmResults

internal class ArticleListAdapter(
    private val dataList: RealmResults<ArticlesItem>,
    private val router: ActivityRouter
) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemArticleBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_article,
                parent,
                false
            )
        return ItemViewHolder(binding, ArticleItemViewModel())
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal inner class ItemViewHolder(
        private val binding: ItemArticleBinding,
        private val viewModel: ArticleItemViewModel
    ) : ViewHolder(binding.root) {
        fun bind(repoModel: ArticlesItem?) {
            viewModel.articlesItem = repoModel
            binding.vm = viewModel
            binding.executePendingBindings()
            binding.parent.setOnClickListener {
                router.startNewsDetailActivity(repoModel!!)
            }
        }

    }

}