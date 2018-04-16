package com.example.vitaly.galleryforyandex.DataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class LinksObject(@SerializedName("self") @Expose val self:String,
                       @SerializedName("alternate") @Expose val alternate:String)