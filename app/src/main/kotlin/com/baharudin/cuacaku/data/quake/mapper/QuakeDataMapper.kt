package com.baharudin.cuacaku.data.quake.mapper

import com.baharudin.cuacaku.data.quake.dto.QuakeResponse
import com.baharudin.cuacaku.domain.quake.model.QuakeEntity

fun QuakeResponse.toQuakeEntity(): QuakeEntity {
    return QuakeEntity(
        tanggal = tanggal,
        jam = jam,
        datetime = datetime,
        coordinates = coordinates,
        lintang = lintang,
        bujur = bujur,
        magnitude = magnitude,
        kedalaman = kedalaman,
        wilayah = wilayah,
        potensi = potensi,
        dirasakan = dirasakan
    )
}