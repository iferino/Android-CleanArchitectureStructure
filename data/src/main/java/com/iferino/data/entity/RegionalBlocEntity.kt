package com.iferino.data.entity

import com.google.gson.annotations.SerializedName

data class RegionalBlocEntity(
        @SerializedName("acronym")
        val acronym: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("otherAcronyms")
        val otherAcronyms: List<String>,

        @SerializedName("otherNames")
        val otherNames: List<String>
)
