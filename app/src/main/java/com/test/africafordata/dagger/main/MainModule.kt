package com.test.africafordata.dagger.main

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.test.africafordata.R
import com.test.africafordata.adapter.DevicesAdapter
import dagger.Module
import dagger.Provides


@Module
object MainModule {

    @JvmStatic
    @Provides
    fun provideUserDrawable(application: Application):Drawable{
        return ContextCompat.getDrawable(application, R.drawable.johndoe)!!
    }

    @JvmStatic
    @Provides
    fun provideDevicesAdapter():DevicesAdapter{
        return DevicesAdapter()
    }

}