package com.example.vitaly.galleryforyandex.DataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


open class ImgObject(@SerializedName("XXS") @Expose var xxs: BasicImage? = null,
                     @SerializedName("XL") @Expose var xl: BasicImage? = null,
                     @SerializedName("M") @Expose var m: BasicImage? = null,
                     @SerializedName("L") @Expose var l: BasicImage? = null,
                     @SerializedName("XXXS") @Expose var xxxs: BasicImage? = null,
                     @SerializedName("XXXL") @Expose var xxxl: BasicImage? = null,
                     @SerializedName("S") @Expose var s: BasicImage? = null,
                     @SerializedName("XS") @Expose var xs: BasicImage? = null,
                     @SerializedName("XXL") @Expose var xxl: BasicImage? = null,
                     @SerializedName("orig") @Expose var original: BasicImage? = null) : RealmObject()
// Класс, содержащий сами картинки разных размеров
// Каждому полю пришлось дать дефолтное значение, по-другому realm отказывался работать