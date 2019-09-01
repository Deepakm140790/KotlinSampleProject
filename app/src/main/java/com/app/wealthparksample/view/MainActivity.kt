package com.app.wealthparksample.view

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.app.wealthparksample.R
import com.app.wealthparksample.model.VerticalViewModel
import com.app.wealthparksample.model.HorizontalViewModel
import com.app.wealthparksample.modelview.DataViewModel
import com.app.wealthparksample.util.PrintLog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), HorizontalViewAdapter.ClickListener {
    private val TAG: String = "MainActivity"
    private val horList = ArrayList<HorizontalViewModel>()
    private val verList = ArrayList<VerticalViewModel>()

    private var mHorizontalViewAdapter: HorizontalViewAdapter? = null
    private var mVerticalViewAdapter: VerticalViewAdapter? = null

    private var mDataViewModel: DataViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //View model
        mDataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        initRecyclerView()
        initRecyclerView2()

        loadHorData()
        loadVerData()
    }

    private fun loadHorData() {
        mDataViewModel!!.horData.observe(this, Observer { horizontalViewModels ->
            horList.clear()
            horList.addAll(horizontalViewModels)
            mHorizontalViewAdapter!!.notifyDataSetChanged()
        })
    }

    private fun loadVerData() {
        mDataViewModel!!.verData.observe(this, Observer { verticalViewModels ->
            verList.clear()
            verList.addAll(verticalViewModels)
            mVerticalViewAdapter!!.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        PrintLog.d(TAG, "initRecyclerView: init recyclerview")

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addOnItemTouchListener(HorizontalViewAdapter.RecyclerTouchListener(applicationContext, recyclerView, this))

        mHorizontalViewAdapter = HorizontalViewAdapter(this, horList)
        recyclerView.adapter = mHorizontalViewAdapter
    }

    private fun initRecyclerView2() {
        PrintLog.d(TAG, "initRecyclerView: init recyclerview2")

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView2.layoutManager = layoutManager
        mVerticalViewAdapter = VerticalViewAdapter(this, verList)
        recyclerView2.adapter = mVerticalViewAdapter
    }

    override fun onClick(view: View, position: Int) {
        val intent = Intent(this, WebActivity::class.java)
        intent.putExtra("url", "https://www.google.com/")
        startActivity(intent)
    }
}
