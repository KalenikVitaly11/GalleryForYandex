package com.example.vitaly.galleryforyandex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Links1(@SerializedName("album") @Expose val album:String,
                       @SerializedName("editMedia") @Expose val editMedia:String,
                       @SerializedName("self") @Expose val self:String,
                       @SerializedName("alternate") @Expose val alternate:String,
                       @SerializedName("edit") @Expose val edit:String)