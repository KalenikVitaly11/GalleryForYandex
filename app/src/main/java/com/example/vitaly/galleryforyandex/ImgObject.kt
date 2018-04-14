package com.example.vitaly.galleryforyandex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ImgObject(@SerializedName("XXS") @Expose val xxs:BasicImage,
                     @SerializedName("XL") @Expose val xl:BasicImage,
                     @SerializedName("M") @Expose val m:BasicImage,
                     @SerializedName("L") @Expose val l:BasicImage,
                     @SerializedName("XXXS") @Expose val xxxs:BasicImage,
                     @SerializedName("XXXL") @Expose val xxxl:BasicImage,
                     @SerializedName("S") @Expose val s:BasicImage,
                     @SerializedName("XS") @Expose val xs:BasicImage,
                     @SerializedName("XXL") @Expose val xxl:BasicImage,
                     @SerializedName("orig") @Expose val original:BasicImage)