package com.example.vitaly.galleryforyandex.DataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Authors (@SerializedName("name") @Expose var name: String = "",
                    @SerializedName("uid") @Expose var uid: String = ""): RealmObject()