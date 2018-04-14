package com.example.vitaly.galleryforyandex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Authors (@SerializedName("name") @Expose val name: Boolean,
                    @SerializedName("uid") @Expose val uid: Boolean)