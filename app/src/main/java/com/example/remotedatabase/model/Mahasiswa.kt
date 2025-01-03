package com.example.remotedatabase.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mahasiswa (
    val nim: String,
    val nama: String,
    val alamat: String,

    @SerialName("jenisKelamin")
    val jenisKelamin: String,

    val kelas: String,
    val angkatan: String
)
