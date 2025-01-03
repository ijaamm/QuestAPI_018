package com.example.praktikum10.Service

import com.example.praktikum10.model.Mahasiswa
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface MahasiswaService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )

//    @POST("insertmahasiswa.php")
    @POST("store")
    suspend fun insertMahasiswa( @Body mahasiswa: Mahasiswa)

//    @GET("bacamahasiswa.php")
    @GET(".")
    suspend fun getAllMahasiswa(): List<Mahasiswa>

//    @GET("baca1mahasiswa.php/{nim}")
    @GET("{nim}")
    suspend fun getMahasiswaByNim(@Query("nim") nim: String): Mahasiswa

//    @PUT("editmahasiswa.php/{nim}")
    @PUT("{nim}")
    suspend fun updateMahasiswa(@Query("nim") nim: String, @Body mahasiswa: Mahasiswa)

//    @DELETE("deletemahasiswa.php/{nim}")
    @DELETE("{nim}")
    suspend fun deleteMahasiswa(@Query("nim") nim: String): retrofit2.Response<Void>

}
