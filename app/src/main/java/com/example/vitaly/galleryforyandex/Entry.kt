package com.example.vitaly.galleryforyandex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Entry(@SerializedName("edited") @Expose val editedTime: String,
                 @SerializedName("updated") @Expose val updatedTime: String,
                 @SerializedName("xxx") @Expose val xxx: Boolean,
                 @SerializedName("img") @Expose val photo: ImgObject,
                 @SerializedName("links") @Expose val links: Links1,
//                 @SerializedName("tags") @Expose val tags: ArrayList<String>,
                 @SerializedName("title") @Expose val title: String,
                 @SerializedName("access") @Expose val access: String,
                 @SerializedName("podDate") @Expose val podDate: String,
                 @SerializedName("created") @Expose val created: String,
                 @SerializedName("disableComments") @Expose val disableComments: Boolean,
                 @SerializedName("authors") @Expose val authors: ArrayList<Authors>,
                 @SerializedName("hideOriginal") @Expose val hideOriginal: Boolean,
                 @SerializedName("author") @Expose val author: String,
                 @SerializedName("id") @Expose val id: String,
                 @SerializedName("published") @Expose val publishedTime: String)