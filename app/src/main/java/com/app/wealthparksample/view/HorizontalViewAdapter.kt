package com.app.wealthparksample.view

import android.content.Context
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.app.wealthparksample.R
import com.app.wealthparksample.model.HorizontalViewModel
import com.app.wealthparksample.util.PrintLog
import com.bumptech.glide.Glide

import java.util.ArrayList

import de.hdodenhof.circleimageview.CircleImageView

class HorizontalViewAdapter(private val mContext: Context, private val mImageUrls: ArrayList<HorizontalViewModel>) : RecyclerView.Adapter<HorizontalViewAdapter.ViewHolder>() {
    private val TAG: String = "HorizontalViewAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        PrintLog.d(TAG, "onBindViewHolder: called.")

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls[position].url)
                .into(holder.image)
    }

    override fun getItemCount(): Int {
        return mImageUrls.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var image: CircleImageView = itemView.findViewById(R.id.image_view)
    }

    /**
     * Interface is used to send the onClick events to client.
     */
    interface ClickListener {
        fun onClick(view: View, position: Int)
    }

    /**
     * This class implements RecyclerView OnItemTouchListener.
     */
    class RecyclerTouchListener(context: Context, recyclerView: RecyclerView,
                                private val clickListener: ClickListener?) : RecyclerView.OnItemTouchListener {
        private val gestureDetector: GestureDetector

        init {
            gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    val child = recyclerView.findChildViewUnder(e.x, e.y)
                    if (child != null && clickListener != null) {

                    }
                }
            })
        }

        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
            val child = rv.findChildViewUnder(e.x, e.y)
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child))
            }
            return false
        }

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
    }
}
