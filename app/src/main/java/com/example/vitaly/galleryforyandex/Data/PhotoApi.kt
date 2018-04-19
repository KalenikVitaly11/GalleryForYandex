package com.example.vitaly.galleryforyandex.Data

import com.example.vitaly.galleryforyandex.DataClasses.PhotoResponseObject
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface PhotoApi {

    @Headers("Accept: application/json")
    @GET("api/podhistory/")
    fun getPhotosOfTheDay(): Observable<Response<PhotoResponseObject>>


    companion object {
        fun create(): PhotoApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://api-fotki.yandex.ru/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return  retrofit.create(PhotoApi::class.java)
        }
    }
}