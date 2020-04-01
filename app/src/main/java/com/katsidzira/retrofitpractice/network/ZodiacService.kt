package com.katsidzira.news_app.network

import android.database.Observable
import com.katsidzira.news_app.model.ZodiacList
import retrofit2.Call
import retrofit2.http.GET

interface ZodiacService {

    @GET("/JDVila/storybook/master/zodiac.json")
    fun getZodiacDetails(): Call<ZodiacList>

}