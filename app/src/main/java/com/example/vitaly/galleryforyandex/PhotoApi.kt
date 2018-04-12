package com.example.vitaly.galleryforyandex

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


interface PhotoApi {
    @POST("/networks")
    fun getPhotosOfTheDay(): Observable<Response<PhotoResponseObject>>


    companion object {
        fun create(): PhotoApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://api-fotki.yandex.ru/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return  retrofit.create(PhotoApi::class.java)
        }
    }
}