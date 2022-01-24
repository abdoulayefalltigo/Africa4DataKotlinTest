package com.test.africafordata.di

import com.test.africafordata.di.main.MainFragmentBuilderModule
import com.test.africafordata.di.main.MainModule
import com.test.africafordata.di.main.MainViewModelModule
import com.test.africafordata.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {


    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuilderModule::class,
            MainModule::class,
            MainViewModelModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}