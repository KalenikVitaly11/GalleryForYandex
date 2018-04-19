package com.example.vitaly.galleryforyandex.FullscreenImagePreview

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.*
import com.example.vitaly.galleryforyandex.R
import com.github.chrisbanes.photoview.PhotoView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class FullScreenImageActivity : AppCompatActivity() {
    private lateinit var imageName: TextView
    private lateinit var imageNameTitle: TextView
    private lateinit var imageAuthor: TextView
    private lateinit var imageAuthorTitle: TextView
    private lateinit var imageLink:TextView
    private lateinit var fullscreenImage: PhotoView // Я решил не изобретать велосипед и взять готовое решение с поддержкой всех жестов
    private lateinit var goBack: ImageButton
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        fullscreenImage = findViewById(R.id.fullscreen_image)
        imageName = findViewById(R.id.fullscreen_image_name)
        imageAuthor = findViewById(R.id.fullscreen_author)
        progressBar = findViewById(R.id.fullscreen_progress_bar)
        imageNameTitle = findViewById(R.id.fullscreen_image_name_title)
        imageAuthorTitle = findViewById(R.id.fullscreen_author_title)
        imageLink = findViewById(R.id.fullscreen_image_link)

        imageName.text = intent.getStringExtra("name") // достаем нужные значения из intent и кладем в нужные view
        imageAuthor.text = intent.getStringExtra("author")
        imageLink.text = intent.getStringExtra("link")
        Picasso.with(this)
                .load(intent.getStringExtra("image"))
                .into(fullscreenImage, object : com.squareup.picasso.Callback { // Слушаем загрузку картинки
                    override fun onSuccess() {
                        progressBar.visibility = View.GONE
                    }

                    override fun onError() {
                        Toast.makeText(this@FullScreenImageActivity, "Ошибка", Toast.LENGTH_LONG)
                                .show()
                        progressBar.visibility = View.GONE
                    }
                })


        goBack = findViewById(R.id.fullscreen_back)
        goBack.setOnClickListener { view ->
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
