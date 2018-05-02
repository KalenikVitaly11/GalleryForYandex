package com.example.vitaly.galleryforyandex.dataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Entry(@SerializedName("img") @Expose var photo: ImgObject? =
                         ImgObject(null, null, null, null, null, null, null, null, null, null),
                 @SerializedName("links") @Expose var linksPhoto: LinksPhoto? = null,
                 @SerializedName("title") @Expose var title: String = "",
                 @SerializedName("author") @Expose var author: String = "",
                 @SerializedName("id") @Expose var id: String = ""):RealmObject()
// Класс "Яндекс.Фотка"
// Каждому полю пришлось дать дефолтное значение, по-другому realm отказывался работать