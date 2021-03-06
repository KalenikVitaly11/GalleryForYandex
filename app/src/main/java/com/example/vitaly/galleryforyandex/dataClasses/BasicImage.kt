package com.example.vitaly.galleryforyandex.dataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


open class BasicImage(@SerializedName("width") @Expose var width:Int? = null,
                      @SerializedName("href") @Expose var source:String? = "",
                      @SerializedName("bytesize") @Expose var size:Int? = null,
                      @SerializedName("height") @Expose var height:Int? = null): RealmObject()
// Класс самой картинки
// Каждому полю пришлось дать дефолтное значение, по-другому realm отказывался работать