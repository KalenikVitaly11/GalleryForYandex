package com.example.vitaly.galleryforyandex.Gallery

import com.example.vitaly.galleryforyandex.Entry
import com.example.vitaly.galleryforyandex.PhotoResponseObject


interface GalleryView {
    fun photoRequestError()
    fun updateRecyclerView(newPhotos:ArrayList<Entry>)
}