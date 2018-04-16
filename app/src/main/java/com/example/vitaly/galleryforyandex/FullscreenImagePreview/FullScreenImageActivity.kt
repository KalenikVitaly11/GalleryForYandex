package com.example.vitaly.galleryforyandex.FullscreenImagePreview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.example.vitaly.galleryforyandex.R
import com.squareup.picasso.Picasso

class FullScreenImageActivity : AppCompatActivity(){
    lateinit var imageName:TextView
    lateinit var imageAuthor:TextView
    lateinit var fullscreenImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        fullscreenImage = findViewById(R.id.fullscreen_image)
        imageName = findViewById(R.id.fullscreen_image_name)
        imageAuthor = findViewById(R.id.fullscreen_author)

        title = ""

        imageName.text = intent.getStringExtra("name") // доставем нужные значения из intent и кладем куда надо
        imageAuthor.text = intent.getStringExtra("author")
        Picasso.with(this)
                .load(intent.getStringExtra("image"))
                .into(fullscreenImage)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
