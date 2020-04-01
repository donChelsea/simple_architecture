package com.katsidzira.news_app.model


import com.google.gson.annotations.SerializedName

data class ZodiacList(
    @SerializedName("zodiac")
    val zodiacList: List<Zodiac>
)