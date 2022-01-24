package com.test.africafordata.di.main

import androidx.lifecycle.ViewModel
import com.test.africafordata.di.ViewModelKey
import com.test.africafordata.ui.fragments.home.HomeViewModel
import com.test.africafordata.ui.fragments.user.UserViewModel
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