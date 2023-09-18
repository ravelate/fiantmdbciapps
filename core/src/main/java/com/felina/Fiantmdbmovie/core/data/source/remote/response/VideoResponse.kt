package com.felina.Fiantmdbmovie.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListVideoResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("results")
	val results: List<VideoResponse>
)

data class VideoResponse(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("site")
	val site: String,

	@field:SerializedName("size")
	val size: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("official")
	val official: Boolean,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("published_at")
	val publishedAt: String,

	@field:SerializedName("key")
	val key: String
)
