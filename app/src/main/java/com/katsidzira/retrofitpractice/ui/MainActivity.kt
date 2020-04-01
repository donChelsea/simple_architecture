package com.katsidzira.retrofitpractice.ui

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.katsidzira.news_app.model.ZodiacList
import com.katsidzira.news_app.network.RetrofitClient
import com.katsidzira.news_app.network.ZodiacService
import com.katsidzira.retrofitpractice.R
import com.katsidzira.retrofitpractice.controller.ZodiacAdapter
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

        val zodiacService = retrofit.create(ZodiacService::class.java)
        zodiacService.getZodiacDetails().enqueue(object: Callback<ZodiacList> {
            override fun onResponse(call: Call<ZodiacList>, response: Response<ZodiacList>) {
                val zodiacList = response.body()?.zodiacList
                recyclerview.adapter = ZodiacAdapter(zodiacList!!)
                recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<ZodiacList>, t: Throwable) {
                sequenceOf(Toast.makeText(applicationContext, "Unable to get data", Toast.LENGTH_SHORT).show())
            }

        })
    }
}
