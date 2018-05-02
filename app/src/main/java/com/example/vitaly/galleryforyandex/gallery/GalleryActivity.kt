package com.example.vitaly.galleryforyandex.gallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.vitaly.galleryforyandex.dataClasses.Entry
import com.example.vitaly.galleryforyandex.GridSpacingItemDecoration
import com.example.vitaly.galleryforyandex.data.PhotoRepository
import com.example.vitaly.galleryforyandex.data.PhotoRepositoryImpl
import com.example.vitaly.galleryforyandex.R
import io.realm.Realm
import io.realm.internal.network.NetworkStateReceiver

class GalleryActivity : AppCompatActivity(), GalleryView {
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var photoRecyclerViewAdapter: PhotoRecyclerViewAdapter
    private val dataPhotos = ArrayList<Entry>()
    private lateinit var presenter: GalleryPresenter
    private lateinit var model: PhotoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = PhotoRepositoryImpl()
        presenter = GalleryPresenter(this, model)
        presenter.initRecyclerView()


        swipeRefreshLayout = findViewById(R.id.photos_swipe_refresh)
        swipeRefreshLayout.setOnRefreshListener {
            presenter.getPhotosOfTheDay()
            swipeRefreshLayout.isRefreshing = true
        }

        if (savedInstanceState != null) { // Решаем проблему пересоздания активити
            updateRecyclerView(presenter.getCachedPhotos()) // Сделал загрузку из бд,
            // потому что возникала ошибка при передаче параметров из адаптера в активити с фотографией на полный экран

            // Что я только не пробовал - ничего не работает для сохранения прокрутки recyclerView, возможно из-за того, что nestedScrolling = false,
            //  а layoutManager - gridLayoutManager
        } else {
            // Если активити создана впервые, то делаем запрос
            swipeRefreshLayout.isRefreshing = true
            presenter.getPhotosOfTheDay()
        }

    }

    override fun initRecyclerView() {
        recyclerView = findViewById(R.id.photos_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // RecyclerView из двух столбцов
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, 3))
        photoRecyclerViewAdapter = PhotoRecyclerViewAdapter(dataPhotos, this)
        recyclerView.adapter = photoRecyclerViewAdapter
    }

    override fun photoRequestError() {
        Toast.makeText(this, resources.getText(R.string.error).toString(), Toast.LENGTH_SHORT).show()
        swipeRefreshLayout.isRefreshing = false
    }

    override fun updateRecyclerView(newPhotos: ArrayList<Entry>) {
        photoRecyclerViewAdapter.clearData()
        photoRecyclerViewAdapter.updateData(newPhotos)
        swipeRefreshLayout.isRefreshing = false
    }
}
