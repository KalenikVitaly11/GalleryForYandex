package com.example.vitaly.galleryforyandex.dataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class LinksPhoto(@SerializedName("album") @Expose var album:String = "",
                      @SerializedName("editMedia") @Expose var editMedia:String = "",
                      @SerializedName("self") @Expose var self:String = "",
                      @SerializedName("alternate") @Expose var alternate:String = "",
                      @SerializedName("edit") @Expose var edit:String = ""): RealmObject()
// Класс, хранящий ссылки на саму фотографию
// Каждому полю пришлось дать дефолтное значение, по-другому realm отказывался работать