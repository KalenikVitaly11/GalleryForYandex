package com.example.vitaly.galleryforyandex

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import io.realm.Realm



class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        if(LeakCanary.isInAnalyzerProcess(this)){
            return
        }
        LeakCanary.install(this)
    }
}