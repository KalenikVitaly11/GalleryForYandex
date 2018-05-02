package com.example.vitaly.galleryforyandex.data

import com.example.vitaly.galleryforyandex.dataClasses.Entry
import com.example.vitaly.galleryforyandex.dataClasses.PhotoResponseObject
import retrofit2.Response
import io.reactivex.Observable
import kotlin.collections.ArrayList

interface PhotoRepository {
    fun getPhotosOfTheDay():Observable<Response<PhotoResponseObject>>
    fun insertToDataBase(entryList:ArrayList<Entry>)
    fun getFromDataBase():ArrayList<Entry>
    fun closeDataBase()
}