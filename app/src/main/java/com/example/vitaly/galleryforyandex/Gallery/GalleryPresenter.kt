package com.example.vitaly.galleryforyandex.Gallery

import android.util.Log
import com.example.vitaly.galleryforyandex.PhotoRecyclerViewAdapter
import com.example.vitaly.galleryforyandex.PhotoResponseObject
import io.reactivex.Observable
import retrofit2.Response


class GalleryPresenter(val view: GalleryView, val model: PhotoRepository) {
    fun getPhotosOfTheDay() {
        model.getPhotosOfTheDay()
                .map { response ->
                    Log.d("myLogs", response.code().toString())
                    Log.d("myLogs", response.headers().toString())
                    Log.d("myLogs", response.toString())
                    if (!response.isSuccessful) {
                        view.photoRequestError()
                    }
                    return@map response.body()
                }
                .subscribe({ photosList ->
                    view.updateRecyclerView(photosList!!.photosList)
                }, { throwable ->
                    Log.d("myLogs", throwable.toString())
                    view.photoRequestError()
                })
    }
}