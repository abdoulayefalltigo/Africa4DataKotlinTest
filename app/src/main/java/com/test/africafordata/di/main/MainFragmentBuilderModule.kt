package com.test.africafordata.di.main

import com.test.africafordata.ui.fragments.home.HomeFragment
import com.test.africafordata.ui.fragments.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainFragmentBuilderModule {


    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment


    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment


}