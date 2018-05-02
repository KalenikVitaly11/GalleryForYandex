package com.example.vitaly.galleryforyandex.gallery

import com.example.vitaly.galleryforyandex.dataClasses.Entry


interface GalleryView {
    fun photoRequestError()
    fun initRecyclerView()
    fun updateRecyclerView(newPhotos:ArrayList<Entry>)
}