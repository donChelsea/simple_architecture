package com.katsidzira.retrofitpractice.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.katsidzira.news_app.model.Zodiac
import com.katsidzira.retrofitpractice.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_single_zodiac.view.*
import kotlinx.android.synthetic.main.zodiac_list_view.view.*

class ZodiacAdapter(private val zodiacList: List<Zodiac>): RecyclerView.Adapter<ZodiacViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZodiacViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.zodiac_list_view, parent, false)
        return ZodiacViewHolder(view)
    }

    override fun getItemCount() = zodiacList.size

    override fun onBindViewHolder(holder: ZodiacViewHolder, position: Int) {
        holder.onBind(zodiacList[position])
    }
}

class ZodiacViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun onBind(zodiac: Zodiac) {
        itemView.zodiac_name_text.text = zodiac.name
        itemView.zodiac_date_text.text = zodiac.number
        Picasso.get().load(zodiac.image).into(itemView.zodiac_image)
    }

}