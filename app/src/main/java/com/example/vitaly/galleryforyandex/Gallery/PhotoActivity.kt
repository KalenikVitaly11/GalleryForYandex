package com.example.vitaly.galleryforyandex.Gallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.vitaly.galleryforyandex.Entry
import com.example.vitaly.galleryforyandex.PhotoRecyclerViewAdapter
import com.example.vitaly.galleryforyandex.PhotoResponseObject
import com.example.vitaly.galleryforyandex.R

class PhotoActivity : AppCompatActivity(), GalleryView {
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var recyclerView: RecyclerView
    lateinit var photoRecyclerViewAdapter: PhotoRecyclerViewAdapter
    private val dataPhotos = ArrayList<Entry>()
    private lateinit var presenter:GalleryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = PhotoRepositoryImpl()
        presenter = GalleryPresenter(this, model)
        swipeRefreshLayout = findViewById(R.id.photos_swipe_refresh)
        swipeRefreshLayout.isRefreshing = true

        setTitle("Галерея")

        recyclerView = findViewById(R.id.photos_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setNestedScrollingEnabled(false);
        photoRecyclerViewAdapter = PhotoRecyclerViewAdapter(dataPhotos, this)
        recyclerView.adapter = photoRecyclerViewAdapter

        swipeRefreshLayout.setOnRefreshListener {
            presenter.getPhotosOfTheDay()
            swipeRefreshLayout.isRefreshing = true
        }
        presenter.getPhotosOfTheDay()
    }

    override fun photoRequestError() {
        Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_SHORT).show()
        swipeRefreshLayout.isRefreshing = false
    }

    override fun updateRecyclerView(newPhotos:ArrayList<Entry>) {
        photoRecyclerViewAdapter.clearData()
        photoRecyclerViewAdapter.updateData(newPhotos)
        swipeRefreshLayout.isRefreshing = false
    }
}
