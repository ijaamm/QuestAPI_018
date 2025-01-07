package com.example.praktikum10.Service

import com.example.praktikum10.model.AllMahasiswaResponse
import com.example.praktikum10.model.Mahasiswa
import com.example.praktikum10.model.MahasiswaDetailResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
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
    suspend fun getAllMahasiswa(): AllMahasiswaResponse

//    @GET("baca1mahasiswa.php/{nim}")
    @GET("{nim}")
    suspend fun getMahasiswaByNim(@Path("nim") nim: String): MahasiswaDetailResponse

//    @PUT("editmahasiswa.php/{nim}")
    @PUT("{nim}")
    suspend fun updateMahasiswa(@Path("nim") nim: String, @Body mahasiswa: Mahasiswa)

//    @DELETE("deletemahasiswa.php/{nim}")
    @DELETE("{nim}")
    suspend fun deleteMahasiswa(@Path("nim") nim: String): retrofit2.Response<Void>

}
