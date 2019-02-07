package jcaselles.bdoprofitcalculator.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jcaselles.bdoprofitcalculator.ui.resource_details.ResourceDetailsActivity
import jcaselles.bdoprofitcalculator.ui.resource_selector.ResourceSelectorActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeResourcesSelectorActivity(): ResourceSelectorActivity

    @ContributesAndroidInjector
    abstract fun contributeResourceDetailsActivity(): ResourceDetailsActivity
}