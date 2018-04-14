package com.example.vitaly.galleryforyandex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class BasicImage(@SerializedName("width") @Expose val width:Int,
                      @SerializedName("href") @Expose val source:String,
                      @SerializedName("bytesize") @Expose val size:Int,
                      @SerializedName("height") @Expose val height:Int)