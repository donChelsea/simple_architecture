package com.katsidzira.news_app.model


import com.google.gson.annotations.SerializedName

data class Zodiac(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: String
)