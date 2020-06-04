package com.nitish.doubtnutassignment.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class ArticlesItem : RealmObject(),Serializable{

     var publishedAt: String? = null
     var author: String? = null
     var urlToImage: String? = null
     var description: String? = null
     var source: Source? = null
     var title: String? = null
     @PrimaryKey
     var url: String? = null
     var content: String? = null
}