package com.iferino.data.entity;


import com.google.gson.annotations.SerializedName

data class CountryEntity(
    @SerializedName("name")
    val name: String,

    @SerializedName("topLevelDomain")
    val topLevelDomain: List<String>,

    @SerializedName("alpha2Code")
    val alpha2Code: String,

    @SerializedName("alpha3Code")
    val alpha3Code: String,

    @SerializedName("callingCodes")
    val callingCodes: List<String>,

    @SerializedName("capital")
    val capital: String,

    @SerializedName("altSpellings")
    val altSpellings: List<String>,

    @SerializedName("region")
    val region: String,

    @SerializedName("subregion")
    val subregion: String,

    @SerializedName("population")
    val population: String,

    @SerializedName("latlng")
    val latlng: List<String>,

    @SerializedName("demonym")
    val demonym: String,

    @SerializedName("area")
    val area: Int,

    @SerializedName("gini")
    val gini: Float,

    @SerializedName("timezones")
    val timezones: List<String>,

    @SerializedName("borders")
    val borders: List<String>,

    @SerializedName("nativeName")
    val nativeName: String,

    @SerializedName("numericCode")
    val numericCode: String,

    @SerializedName("currencies")
    val currencies: List<CurrencyEntity>
)
