package com.example.vitaly.galleryforyandex.Gallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.vitaly.galleryforyandex.DataClasses.Entry
import com.example.vitaly.galleryforyandex.GridSpacingItemDecoration
import com.example.vitaly.galleryforyandex.Data.PhotoRepository
import com.example.vitaly.galleryforyandex.Data.PhotoRepositoryImpl
import com.example.vitaly.galleryforyandex.R
import io.realm.Realm

class GalleryActivity : AppCompatActivity(), GalleryView {
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var photoRecyclerViewAdapter: PhotoRecyclerViewAdapter
    private val dataPhotos = ArrayList<Entry>()
    private lateinit var presenter:GalleryPresenter
    private lateinit var model: PhotoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Яндекс.Фотки"
        Realm.init(this) // По-хорошему инициализировать БД надо в классе application, но я принебрег этим в проекте из двух активити
        model = PhotoRepositoryImpl()
        presenter = GalleryPresenter(this, model)
        presenter.initRecyclerView()

        swipeRefreshLayout = findViewById(R.id.photos_swipe_refresh)
        swipeRefreshLayout.isRefreshing = true
        swipeRefreshLayout.setOnRefreshListener {
            presenter.getPhotosOfTheDay()
            swipeRefreshLayout.isRefreshing = true
        }
        presenter.getPhotosOfTheDay()
    }

    override fun initRecyclerView() {
        recyclerView = findViewById(R.id.photos_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // RecyclerView из двух столбцов
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, 3))
        photoRecyclerViewAdapter = PhotoRecyclerViewAdapter(dataPhotos, this)
        recyclerView.adapter = photoRecyclerViewAdapter
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

    override fun onDestroy() {
        super.onDestroy()
        model.closeDataBase()
    }
}
