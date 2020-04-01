package com.katsidzira.retrofitpractice.ui

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.katsidzira.news_app.model.ZodiacList
import com.katsidzira.news_app.network.RetrofitClient
import com.katsidzira.news_app.network.ZodiacService
import com.katsidzira.retrofitpractice.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "main activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClient().getInstance()

        recyclerview.adapter

        val zodiacService = retrofit.create(ZodiacService::class.java)
        zodiacService.getZodiacDetails().enqueue(object: Callback<ZodiacList> {
            override fun onResponse(call: Call<ZodiacList>, response: Response<ZodiacList>) {
                d(TAG, "zodiac: ${response.body()?.zodiacList?.get(0)?.name}")
            }

            override fun onFailure(call: Call<ZodiacList>, t: Throwable) {
                d(TAG, "failure: ${t.message}")
            }

        })
    }
}
