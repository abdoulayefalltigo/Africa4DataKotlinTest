package com.test.africafordata.dagger

import androidx.lifecycle.ViewModelProvider
import com.test.africafordata.viewmodel.ProviderFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {


    @Binds
    abstract fun bindViewModelFactory(providerFactory: ProviderFactory):ViewModelProvider.Factory
}