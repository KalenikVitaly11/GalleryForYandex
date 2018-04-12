package com.example.vitaly.galleryforyandex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Vitaly on 12.04.2018.
 */
data class PhotoResponseObject(@SerializedName("edited") @Expose val editedTime: String,
                               @SerializedName("updated") @Expose val updatedTime: String,
                               @SerializedName("img") @Expose val imageObject: ImgObject,
                               @SerializedName("links") @Expose val links: LinksObject,
                               @SerializedName("title") @Expose val title: String,
                               @SerializedName("xxx") @Expose val xxx: Boolean,
                               @SerializedName("summary") @Expose val summary: String,
                               @SerializedName("access") @Expose val access: String,
                               @SerializedName("disableComments") @Expose val disableComments: Boolean,
                               @SerializedName("published") @Expose val publishedTime: String,
                               @SerializedName("hideOriginal") @Expose val hideOriginal: Boolean,
                               @SerializedName("author") @Expose val author: String,
                               @SerializedName("id") @Expose val id: String)