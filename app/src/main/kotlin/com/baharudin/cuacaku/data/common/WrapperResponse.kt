package com.baharudin.cuacaku.data.common

import com.google.gson.annotations.SerializedName

data class WrappedResponse<T> (
    @SerializedName("message") var message : String? = null,
    @SerializedName("success") var status : Boolean?,
    @SerializedName("data") var data : T? = null,
)