package com.example.vitaly.galleryforyandex.Gallery

import com.example.vitaly.galleryforyandex.DataClasses.Entry


interface GalleryView {
    fun photoRequestError()
    fun initRecyclerView()
    fun updateRecyclerView(newPhotos:ArrayList<Entry>)
}