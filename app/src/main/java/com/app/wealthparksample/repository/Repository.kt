package com.app.wealthparksample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.app.wealthparksample.model.HorizontalViewModel
import com.app.wealthparksample.model.VerticalViewModel

import java.util.ArrayList

/**
 * Class is responsible to get the Category data from server.
 */
class Repository {

    val verData: LiveData<List<VerticalViewModel>>
        get() {
            val verList = ArrayList<VerticalViewModel>()
            val mutableLiveData = MutableLiveData<List<VerticalViewModel>>()
            var description: String = "Test your Internet connection bandwidth to locations around the world with this interactive broadband speed test from Ookla."

            val m1 = VerticalViewModel("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg", "Havasu Falls", description)
            verList.add(m1)

            val m2 = VerticalViewModel("https://i.redd.it/tpsnoz5bzo501.jpg", "Trondheim", description)
            verList.add(m2)

            val m3 = VerticalViewModel("https://i.redd.it/qn7f9oqu7o501.jpg", "Portugal", description)
            verList.add(m3)

            val m4 = VerticalViewModel("https://i.redd.it/j6myfqglup501.jpg", "Rocky Mountain National Park", description)
            verList.add(m4)

            val m5 = VerticalViewModel("https://i.redd.it/0h2gm1ix6p501.jpg", "Mahahual", description)
            verList.add(m5)

            val m6 = VerticalViewModel("https://i.redd.it/k98uzl68eh501.jpg", "Frozen Lake", description)
            verList.add(m6)

            val m7 = VerticalViewModel("https://i.redd.it/glin0nwndo501.jpg", "White Sands Desert", description)
            verList.add(m7)

            val m8 = VerticalViewModel("https://i.redd.it/obx4zydshg601.jpg", "Australia", description)
            verList.add(m8)

            val m9 = VerticalViewModel("https://i.imgur.com/ZcLLrkY.jpg", "Washington", description)
            verList.add(m9)
            mutableLiveData.value = verList

            return mutableLiveData
        }

    val horData: LiveData<List<HorizontalViewModel>>
        get() {
            val horList = ArrayList<HorizontalViewModel>()
            val mutableLiveData = MutableLiveData<List<HorizontalViewModel>>()

            val m1 = HorizontalViewModel("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg")
            horList.add(m1)

            val m2 = HorizontalViewModel("https://i.redd.it/tpsnoz5bzo501.jpg")
            horList.add(m2)

            val m3 = HorizontalViewModel("https://i.redd.it/qn7f9oqu7o501.jpg")
            horList.add(m3)

            val m4 = HorizontalViewModel("https://i.redd.it/j6myfqglup501.jpg")
            horList.add(m4)

            val m5 = HorizontalViewModel("https://i.redd.it/0h2gm1ix6p501.jpg")
            horList.add(m5)

            val m6 = HorizontalViewModel("https://i.redd.it/k98uzl68eh501.jpg")
            horList.add(m6)

            val m7 = HorizontalViewModel("https://i.redd.it/glin0nwndo501.jpg")
            horList.add(m7)

            val m8 = HorizontalViewModel("https://i.redd.it/obx4zydshg601.jpg")
            horList.add(m8)

            val m9 = HorizontalViewModel("https://i.imgur.com/ZcLLrkY.jpg")
            horList.add(m9)
            mutableLiveData.value = horList

            return mutableLiveData
        }
}
