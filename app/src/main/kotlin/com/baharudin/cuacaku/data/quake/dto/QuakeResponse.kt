package com.baharudin.cuacaku.data.quake.dto

import com.google.gson.annotations.SerializedName

data class QuakeResponse(
    @SerializedName("tanggal")
    var tanggal: String? = null,
    @SerializedName("jam")
    var jam: String? = null,
    @SerializedName("datetime")
    var datetime: String? = null,
    @SerializedName("coordinates")
    var coordinates: String? = null,
    @SerializedName("lintang")
    var lintang: String? = null,
    @SerializedName("bujur")
    var bujur: String? = null,
    @SerializedName("magnitude")
    var magnitude: String? = null,
    @SerializedName("kedalaman")
    var kedalaman: String? = null,
    @SerializedName("wilayah")
    var wilayah: String? = null,
    @SerializedName("potensi")
    var potensi: String? = null,
    @SerializedName("dirasakan")
    var dirasakan: String? = null,
    @SerializedName("shakemap")
    var shakemap: String? = null
)