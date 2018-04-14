package com.example.vitaly.galleryforyandex.Gallery

import com.example.vitaly.galleryforyandex.PhotoApi
import com.example.vitaly.galleryforyandex.PhotoResponseObject
import io.reactivex.Observable
import io.reactivex.Scheduler
import kotlin.collections.ArrayList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class PhotoRepositoryImpl: PhotoRepository {
    override fun getPhotosOfTheDay(): Observable<Response<PhotoResponseObject>> {
        return PhotoApi.create().getPhotosOfTheDay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}