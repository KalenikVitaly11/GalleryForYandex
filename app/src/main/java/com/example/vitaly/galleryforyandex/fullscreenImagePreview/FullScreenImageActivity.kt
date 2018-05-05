package com.example.vitaly.galleryforyandex.fullscreenImagePreview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.vitaly.galleryforyandex.R
import com.github.chrisbanes.photoview.PhotoView
import com.squareup.picasso.Picasso
import java.lang.Exception

class FullScreenImageActivity : AppCompatActivity() {
    private lateinit var imageName: TextView
    private lateinit var imageNameTitle: TextView
    private lateinit var imageAuthor: TextView
    private lateinit var imageAuthorTitle: TextView
    private lateinit var imageLink: TextView
    private lateinit var imageLinkTitle: TextView
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
        imageLinkTitle = findViewById(R.id.fullscreen_image_link_title)

        imageName.text = intent.getStringExtra("name") // достаем нужные значения из intent и кладем в нужные view
        imageAuthor.text = intent.getStringExtra("author")
        imageLink.text = intent.getStringExtra("link")

        Picasso.get()
                .load(intent.getStringExtra("image"))
                .into(fullscreenImage, object : com.squareup.picasso.Callback {
                    override fun onError(e: Exception?) {
                        Toast.makeText(this@FullScreenImageActivity, resources.getString(R.string.error), Toast.LENGTH_LONG)
                                .show()
                        progressBar.visibility = View.GONE
                    } // Слушаем загрузку картинки

                    override fun onSuccess() {
                        progressBar.visibility = View.GONE
                    }
                })


        goBack = findViewById(R.id.fullscreen_back)
        goBack.setOnClickListener { view ->
            finish()
        }

        fullscreenImage.setOnClickListener { view ->
            showOrHideElements()
        }
    }

    private fun showOrHideElements() {
        if (imageNameTitle.visibility == View.VISIBLE) {
            imageName.visibility = View.GONE
            imageNameTitle.visibility = View.GONE
            imageAuthor.visibility = View.GONE
            imageAuthorTitle.visibility = View.GONE
            imageLink.visibility = View.GONE
            imageLinkTitle.visibility = View.GONE
            goBack.visibility = View.GONE
        } else {
            imageName.visibility = View.VISIBLE
            imageNameTitle.visibility = View.VISIBLE
            imageAuthor.visibility = View.VISIBLE
            imageAuthorTitle.visibility = View.VISIBLE
            imageLink.visibility = View.VISIBLE
            imageLinkTitle.visibility = View.VISIBLE
            goBack.visibility = View.VISIBLE
        }
    }
}
