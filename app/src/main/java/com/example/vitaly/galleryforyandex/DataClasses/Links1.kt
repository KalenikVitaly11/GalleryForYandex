package com.example.vitaly.galleryforyandex.DataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Links1(@SerializedName("album") @Expose var album:String = "",
                       @SerializedName("editMedia") @Expose var editMedia:String = "",
                       @SerializedName("self") @Expose var self:String = "",
                       @SerializedName("alternate") @Expose var alternate:String = "",
                       @SerializedName("edit") @Expose var edit:String = ""): RealmObject()