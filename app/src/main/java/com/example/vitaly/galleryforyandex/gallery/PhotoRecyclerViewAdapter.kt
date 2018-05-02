package com.example.vitaly.galleryforyandex.gallery

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vitaly.galleryforyandex.dataClasses.Entry
import com.example.vitaly.galleryforyandex.fullscreenImagePreview.FullScreenImageActivity
import com.example.vitaly.galleryforyandex.ItemClickListener
import com.example.vitaly.galleryforyandex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_photo_item.view.*


class PhotoRecyclerViewAdapter(val data: ArrayList<Entry>, val context: Context) : RecyclerView.Adapter<PhotoRecyclerViewAdapter.ViewHolder>() {

    private var dataPhotos: ArrayList<Entry>

    init {
        this.dataPhotos = data
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_photo_item, parent, false))
    }

    fun clearData() {
        dataPhotos.clear()
        notifyDataSetChanged()
    }

    fun updateData(newPhotos: ArrayList<Entry>) {
        dataPhotos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataPhotos.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        Picasso.with(context)
                .load(dataPhotos.get(position).photo!!.m!!.source)
                .into(holder?.itemPhoto)

        Picasso.with(context) // Заодно кэшируем фотографии, которые будут отображаться с активити с большой фотографией
                // Адаптер - наверное, не лучшее место для этого, но больше неоткуда взять context
                .load(dataPhotos.get(position).photo!!.xl!!.source)
                .fetch()

        holder!!.setClickListener(object : ItemClickListener {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(context, FullScreenImageActivity::class.java)
                intent.putExtra("image", dataPhotos.get(position).photo!!.xl!!.source)
                intent.putExtra("author", dataPhotos.get(position).author)
                intent.putExtra("name", dataPhotos.get(position).title)
                intent.putExtra("link", dataPhotos.get(position).linksPhoto!!.alternate)
                context.startActivity(intent)
            }
        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemPhoto = itemView.item_photo
        private lateinit var clickListener: ItemClickListener

        init {
            itemView.setOnClickListener(this)
        }

        fun setClickListener(itemClickListener: ItemClickListener){
            this.clickListener = itemClickListener
        }

        override fun onClick(view: View) {
            clickListener.onClick(view, position)
        }
    }

}