package com.baharudin.cuacaku.domain.quake.model

import com.google.gson.annotations.SerializedName

data class QuakeEntity(
    var tanggal: String? = null,
    var jam: String? = null,
    var datetime: String? = null,
    var coordinates: String? = null,
    var lintang: String? = null,
    var bujur: String? = null,
    var magnitude: String? = null,
    var kedalaman: String? = null,
    var wilayah: String? = null,
    var potensi: String? = null,
    var dirasakan: String? = null,
    var shakemap: String? = null
)
