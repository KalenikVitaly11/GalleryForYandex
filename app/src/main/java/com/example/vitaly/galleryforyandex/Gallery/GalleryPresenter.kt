package com.example.vitaly.galleryforyandex.Gallery

import android.util.Log
import com.example.vitaly.galleryforyandex.Data.PhotoRepository
import io.reactivex.Observable


class GalleryPresenter(val view: GalleryView, val model: PhotoRepository) {
    fun initRecyclerView(){
        view.initRecyclerView()
    }
    fun getPhotosOfTheDay() {
        model.getPhotosOfTheDay()
                .map { response -> // Достаем список фотографий из объекта с сервера
                    return@map response.body()!!.photosList
                }
                .flatMap { entryList -> // Записываем в базу данных
                    model.insertToDataBase(entryList)
                    return@flatMap Observable.just(entryList)
                }
                .onErrorResumeNext { throwable: Throwable -> // Если происходит ошибка - достаем результат из базы данных
                    return@onErrorResumeNext Observable.just(model.getFromDataBase())
                }
                .subscribe({ photosList ->
                    view.updateRecyclerView(photosList)
                }, { throwable ->
                    Log.d("myLogs", throwable.toString())
                    view.photoRequestError()
                })
    }
}