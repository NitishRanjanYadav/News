package com.nitish.news.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Source(

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("id")
	var id: String? = null
) : RealmObject()