package com.test.africafordata.dagger

import com.test.africafordata.dagger.main.MainFragmentBuilderModule
import com.test.africafordata.dagger.main.MainModule
import com.test.africafordata.dagger.main.MainViewModelModule
import com.test.africafordata.screens.activities.MainActivity
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