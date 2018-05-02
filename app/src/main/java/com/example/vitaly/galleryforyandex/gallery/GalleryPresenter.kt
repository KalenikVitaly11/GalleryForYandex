package com.example.vitaly.galleryforyandex.gallery

import android.util.Log
import com.example.vitaly.galleryforyandex.data.PhotoRepository
import com.example.vitaly.galleryforyandex.dataClasses.Entry
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GalleryPresenter(val view: GalleryView, val model: PhotoRepository) {
    fun initRecyclerView(){
        view.initRecyclerView()
    }

    fun getCachedPhotos():ArrayList<Entry>{
        return model.getFromDataBase()
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
                    if(photosList.isEmpty()){
                        // Если запрос провалился, и из базы данных мы ничего не достали, то оповещаем пользователя об ошибке
                        view.photoRequestError()
                    } else {
                        view.updateRecyclerView(photosList)
                    }
                }, { throwable ->
                    view.photoRequestError()
                })
    }
}