package com.syed.walmartproject.data.util

import com.syed.walmartproject.data.model.APIResponseItem

sealed class NetworkHelper {
    class Success(val response: ArrayList<APIResponseItem>) : NetworkHelper()
    class Error(val message: String) : NetworkHelper()
    object Loading : NetworkHelper()
}