package jcaselles.bdoprofitcalculator.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import jcaselles.bdoprofitcalculator.di.AppViewModelFactory
import jcaselles.bdoprofitcalculator.di.ViewModelKey
import jcaselles.bdoprofitcalculator.ui.resource_details.ResourceDetailsViewModel
import jcaselles.bdoprofitcalculator.ui.resource_selector.ResourceSelectorViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ResourceSelectorViewModel::class)
    abstract fun bindChangePasswordViewModel(resourceSelectorViewModel: ResourceSelectorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ResourceDetailsViewModel::class)
    abstract fun bindResourceDetailsViewModel(detailsViewModel: ResourceDetailsViewModel): ViewModel
}