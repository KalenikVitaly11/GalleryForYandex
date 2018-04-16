package com.example.vitaly.galleryforyandex.Model

import com.example.vitaly.galleryforyandex.DataClasses.Entry
import com.example.vitaly.galleryforyandex.DataClasses.PhotoResponseObject
import retrofit2.Response
import io.reactivex.Observable
import kotlin.collections.ArrayList

interface PhotoRepository {
    fun getPhotosOfTheDay():Observable<Response<PhotoResponseObject>>
    fun insertToDataBase(entryList:ArrayList<Entry>)
    fun getFromDataBase():ArrayList<Entry>
    fun closeDataBase()
}