package com.example.vitaly.galleryforyandex

import android.app.Application
import io.realm.Realm
import com.squareup.picasso.Picasso



class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}