package com.death.designtocode4.model.person

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("known_for")
	val knownFor: List<KnownForItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_path")
	val profilePath: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("adult")
	val adult: Boolean? = null
)