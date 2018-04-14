package com.example.vitaly.galleryforyandex

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    fun clearData(){
        dataPhotos.clear()
        notifyDataSetChanged()
    }

    fun updateData(newPhotos:ArrayList<Entry>){
        dataPhotos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataPhotos.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        Picasso.with(context)
                .load(dataPhotos.get(position).photo.m.source)
                .into(holder?.itemPhoto)
//holder?.itemPhoto.
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemPhoto = itemView.item_photo
    }

}