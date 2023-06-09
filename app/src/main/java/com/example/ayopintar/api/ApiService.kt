package com.example.ayopintar.api

import com.example.ayopintar.api.response.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun loginApi(@Field("username") username: String, @Field("password") password: String) : Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun registerApi(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("confirmPassword") confirmPassword: String,
        @Field("nama") fullname: String,
        @Field("namaSekolah") namaSekolah: String? = null,
        @Field("email") email: String
    ) : Call<RegisterResponse>

    @GET("mataPelajaran")
    fun getListMapel(@Header("Authorization") token: String) : Call<GetListMapelResponse>

    @GET("soal/{kodeMapel}")
    fun getSoal(@Header("Authorization") token: String, @Path("kodeMapel") kodeMaple: String) : Call<GetSoalResponse>

    @GET("historyNilai")
    fun getRiwayatKuis(@Header("Authorization") token: String, @Query("username") username: String) : Call<GetRiwayatKuisResponse>

    @FormUrlEncoded
    @POST("sentence")
    fun postSoal(
        @Header("Authorization") token: String,
        @Field("kode_soal") kodeSoal: String,
        @Field("jawaban") jawaban: String
    ) : Call<PostJawabanResponse>

    @FormUrlEncoded
    @POST("profile")
    fun getprofile(@Header("Authorization") token: String, @Field("username") username: String) : Call<GetProfileResponse>
}