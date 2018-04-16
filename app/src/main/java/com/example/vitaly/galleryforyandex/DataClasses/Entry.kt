package com.example.vitaly.galleryforyandex.DataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

open class Entry(@SerializedName("edited") @Expose var editedTime: String = "",
                 @SerializedName("updated") @Expose var updatedTime: String = "",
                 @SerializedName("xxx") @Expose var xxx: Boolean = false,
                 @SerializedName("img") @Expose var photo: ImgObject? =
                         ImgObject(null, null, null, null, null, null, null, null, null, null),
                 @SerializedName("links") @Expose var links: Links1? = null,
//                 @SerializedName("tags") @Expose var tags: ArrayList<String>,
                 @SerializedName("title") @Expose var title: String = "",
                 @SerializedName("access") @Expose var access: String = "",
                 @SerializedName("podDate") @Expose var podDate: String = "",
                 @SerializedName("created") @Expose var created: String = "",
                 @SerializedName("disableComments") @Expose var disableComments: Boolean = false,
                 @SerializedName("authors") @Expose var authors: RealmList<Authors>? = null,
                 @SerializedName("hideOriginal") @Expose var hideOriginal: Boolean = false,
                 @SerializedName("author") @Expose var author: String = "",
                 @SerializedName("id") @Expose var id: String = "",
                 @SerializedName("published") @Expose var publishedTime: String = ""):RealmObject()