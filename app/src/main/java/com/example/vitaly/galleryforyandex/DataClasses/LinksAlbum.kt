package com.example.vitaly.galleryforyandex.DataClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class LinksAlbum(@SerializedName("self") @Expose val self:String,
                      @SerializedName("alternate") @Expose val alternate:String)
// Класс с ссылакми, которые относятся к альбому "Фото дня"