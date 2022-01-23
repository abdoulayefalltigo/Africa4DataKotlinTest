package com.test.africafordata.dagger.main

import androidx.lifecycle.ViewModel
import com.test.africafordata.dagger.ViewModelKey
import com.test.africafordata.screens.fragments.home.HomeViewModel
import com.test.africafordata.screens.fragments.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel):ViewModel




    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel):ViewModel


}