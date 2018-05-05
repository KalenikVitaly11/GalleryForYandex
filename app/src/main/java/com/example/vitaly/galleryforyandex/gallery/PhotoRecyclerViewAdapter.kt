package com.example.vitaly.galleryforyandex.gallery

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.vitaly.galleryforyandex.dataClasses.Entry
import com.example.vitaly.galleryforyandex.fullscreenImagePreview.FullScreenImageActivity
import com.example.vitaly.galleryforyandex.ItemClickListener
import com.example.vitaly.galleryforyandex.R
import com.squareup.picasso.Picasso


class PhotoRecyclerViewAdapter(val data: ArrayList<Entry>, val context: Context) : RecyclerView.Adapter<PhotoRecyclerViewAdapter.ViewHolder>() {

    private var dataPhotos: ArrayList<Entry> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_photo_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()
                .load(dataPhotos[position].photo!!.m!!.source)
                .into(holder.itemPhoto)

        holder.setClickListener(object : ItemClickListener {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(context, FullScreenImageActivity::class.java)
                intent.putExtra("image", dataPhotos[position].photo!!.xl!!.source)
                intent.putExtra("author", dataPhotos[position].author)
                intent.putExtra("name", dataPhotos[position].title)
                intent.putExtra("link", dataPhotos[position].linksPhoto!!.alternate)
                context.startActivity(intent)
            }
        })
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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var itemPhoto: ImageView = itemView.findViewById(R.id.item_photo)
        private lateinit var clickListener: ItemClickListener

        init {
            itemView.setOnClickListener(this)
        }

        fun setClickListener(itemClickListener: ItemClickListener) {
            this.clickListener = itemClickListener
        }

        override fun onClick(view: View) {
            clickListener.onClick(view, position)
        }
    }

}