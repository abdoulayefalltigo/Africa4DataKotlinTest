package com.test.africafordata.dagger.main

import com.test.africafordata.screens.fragments.home.HomeFragment
import com.test.africafordata.screens.fragments.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainFragmentBuilderModule {


    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment


    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment


}