package com.felina.Fiantmdbmovie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListReviewResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<ReviewResponse>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

data class ReviewResponse(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("content")
	val content: String,

	@field:SerializedName("url")
	val url: String
)