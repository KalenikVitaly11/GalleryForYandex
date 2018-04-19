package com.example.vitaly.galleryforyandex.Data

import com.example.vitaly.galleryforyandex.DataClasses.Entry
import com.example.vitaly.galleryforyandex.DataClasses.PhotoResponseObject
import io.reactivex.Observable
import kotlin.collections.ArrayList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import retrofit2.Response

class PhotoRepositoryImpl: PhotoRepository {
    val realm = Realm.getDefaultInstance()
    override fun getPhotosOfTheDay(): Observable<Response<PhotoResponseObject>> {
        return PhotoApi.create().getPhotosOfTheDay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun insertToDataBase(entryList:ArrayList<Entry>) { // Запись в базу данных
        realm.executeTransaction { transactionRealm ->
            transactionRealm.delete(Entry::class.java)
            transactionRealm.insert(entryList)
        }
    }

    override fun getFromDataBase(): ArrayList<Entry> { // Чтение из базы данных
        val realm = Realm.getDefaultInstance()
        val results = realm.where(Entry::class.java).findAll()
        return ArrayList(results)
    }

    override fun closeDataBase(){ // Закрываем базу данных
        realm.close()
    }
}