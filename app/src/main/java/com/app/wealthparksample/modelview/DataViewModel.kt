package com.app.wealthparksample.modelview

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.app.wealthparksample.model.HorizontalViewModel
import com.app.wealthparksample.model.VerticalViewModel
import com.app.wealthparksample.repository.Repository
import com.app.wealthparksample.util.PrintLog

/**
 * Class is responsible to give the Category data to client.
 */
class DataViewModel : ViewModel() {
    private val TAG: String = "DataViewModel"
    private val mRepository: Repository = Repository()

    val verData: LiveData<List<VerticalViewModel>>
        get() {
            PrintLog.d(TAG, "getCategory: ")
            return mRepository.verData
        }

    val horData: LiveData<List<HorizontalViewModel>>
        get() {
            PrintLog.d(TAG, "getData: ")
            return mRepository.horData
        }

    override fun onCleared() {
        super.onCleared()
        PrintLog.d(TAG, "onCleared: ")
    }
}
