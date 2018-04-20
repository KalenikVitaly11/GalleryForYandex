package com.example.vitaly.galleryforyandex.DataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Vitaly on 12.04.2018.
 */
data class PhotoResponseObject(@SerializedName("updated") @Expose val updatedTime: String,
                               @SerializedName("linksPhoto") @Expose val links: LinksAlbum,
                               @SerializedName("title") @Expose val title: String,
                               @SerializedName("entries") @Expose val photosList: ArrayList<Entry>,
                               @SerializedName("id") @Expose val id: String)
// Объект, который получаем с сервера