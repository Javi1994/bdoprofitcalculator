package jcaselles.bdoprofitcalculator.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jcaselles.bdoprofitcalculator.ui.selector.ResourceSelectorActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeResourcesSelectorActivity(): ResourceSelectorActivity
}