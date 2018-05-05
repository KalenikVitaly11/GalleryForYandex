package com.example.vitaly.galleryforyandex.data

import com.example.vitaly.galleryforyandex.dataClasses.Entry
import com.example.vitaly.galleryforyandex.dataClasses.PhotoResponseObject
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import kotlin.collections.ArrayList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import retrofit2.Response

class PhotoRepositoryImpl : PhotoRepository {
    private val realm: Realm = Realm.getDefaultInstance()
    override fun getPhotosOfTheDay(): Observable<Response<PhotoResponseObject>> { // Запрос на получение фотографий
        return PhotoApi.create().getPhotosOfTheDay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun insertToDataBase(entryList: ArrayList<Entry>) { // Запись в базу данных
        entryList.forEach {
            Picasso.get() // Кэшируем фотографии, которые будут отображаться в активити с большой фотографией на случай,
                    // если у пользователя внезапно пропадет интернет
                    .load(it.photo!!.xl!!.source)
                    .fetch()
        }
        realm.executeTransaction { transactionRealm ->
            transactionRealm.delete(Entry::class.java)
            transactionRealm.insert(entryList)
        }
        closeDataBase()
    }

    override fun getFromDataBase(): ArrayList<Entry> { // Чтение из базы данных
        val realm = Realm.getDefaultInstance()
        val results = realm.where(Entry::class.java).findAll()
        closeDataBase()
        return ArrayList(results)
    }

    override fun closeDataBase() { // Закрываем базу данных
        realm.close()
    }
}