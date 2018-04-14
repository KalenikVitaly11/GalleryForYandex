package com.example.vitaly.galleryforyandex.Gallery

import com.example.vitaly.galleryforyandex.PhotoResponseObject
import retrofit2.Response
import io.reactivex.Observable
import kotlin.collections.ArrayList

interface PhotoRepository {
    fun getPhotosOfTheDay():Observable<Response<PhotoResponseObject>>
}