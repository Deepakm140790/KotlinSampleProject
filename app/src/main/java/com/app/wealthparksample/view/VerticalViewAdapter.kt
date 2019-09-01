package com.app.wealthparksample.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.app.wealthparksample.R
import com.app.wealthparksample.model.VerticalViewModel
import com.app.wealthparksample.util.PrintLog
import com.bumptech.glide.Glide

import java.util.ArrayList

class VerticalViewAdapter(private val mContext: Context, private val mModel: ArrayList<VerticalViewModel>) : RecyclerView.Adapter<VerticalViewAdapter.ViewHolder>() {
    private val TAG: String = "VerticalViewAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        PrintLog.d(TAG, "onBindViewHolder: called.")

        Glide.with(mContext)
                .asBitmap()
                .load(mModel[position].url)
                .into(holder.image)

        holder.title.text = mModel[position].title
        holder.details.text = mModel[position].description
    }

    override fun getItemCount(): Int {
        return mModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var image: ImageView = itemView.findViewById(R.id.image_view)
        internal var title: TextView = itemView.findViewById(R.id.title)
        internal var details: TextView = itemView.findViewById(R.id.details)
    }
}

