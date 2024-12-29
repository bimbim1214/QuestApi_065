package com.example.remotedatabase.repository

import com.example.remotedatabase.model.Mahasiswa
import com.example.remotedatabase.service_api.MahasiswaService
import java.io.IOException


class NetworkMahasiswaRepository(
    private val mahasiswaApiService: MahasiswaService
): MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        mahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful){
                throw IOException("Failed to delete mahasiswa. HTTP status code: " +
                "${response.code()}")
            }else{
                response.message()
                println(response.message())
            }
        }catch (e:Exception){
            throw e
        }
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> = mahasiswaApiService.getMahasiswa()

    override suspend fun getMahasiswaByNim(nim: String): Mahasiswa {
        return mahasiswaApiService.getMahsiswaByNim(nim)
    }
}