package com.test.africafordata.dagger

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.test.africafordata.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object AppModule{



    @Singleton
    @JvmStatic
    @Provides
    fun provideRequestOptions() = RequestOptions.placeholderOf(R.drawable.heater_bg)
        .error(R.drawable.background).centerCrop()


    @Singleton
    @JvmStatic
    @Provides
    fun provideRequestManager(application: Application,requestOptions: RequestOptions) = Glide.with(application)
        .setDefaultRequestOptions(requestOptions)





}