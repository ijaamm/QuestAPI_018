package com.example.praktikum10.repository

import com.example.praktikum10.Service.MahasiswaService
import com.example.praktikum10.model.AllMahasiswaResponse
import com.example.praktikum10.model.Mahasiswa
import okio.IOException


interface MahasiswaRepository {
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun getMahasiswa(): AllMahasiswaResponse

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun deleteMahasiswa(nim: String)

    suspend fun getMahasiswaByNim(nim: String): Mahasiswa
}

class NetworkKontakRepository(
    private val kontakApiService: MahasiswaService
) : MahasiswaRepository {

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        kontakApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        kontakApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun getMahasiswa(): AllMahasiswaResponse {
        return kontakApiService.getAllMahasiswa()
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val reponse = kontakApiService.deleteMahasiswa(nim)
            if (!reponse.isSuccessful) {
                throw IOException("Failed to delete kontak. HTTP Status code: " +
                        "${reponse.code()}")
            } else {
                reponse.message()
                println(reponse.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getMahasiswaByNim(nim: String): Mahasiswa {
        return kontakApiService.getMahasiswaByNim(nim).data
    }
}