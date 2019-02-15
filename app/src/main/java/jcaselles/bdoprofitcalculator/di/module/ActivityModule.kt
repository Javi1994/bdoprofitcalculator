package jcaselles.bdoprofitcalculator.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jcaselles.bdoprofitcalculator.ui.HomeActivity
import jcaselles.bdoprofitcalculator.ui.bosses.BossSettingsActivity
import jcaselles.bdoprofitcalculator.ui.failstacks.FailstackSimulatorActivity
import jcaselles.bdoprofitcalculator.ui.processing.PlainProcessingActivity
import jcaselles.bdoprofitcalculator.ui.resource_details.ResourceDetailsActivity
import jcaselles.bdoprofitcalculator.ui.resource_selector.ResourceSelectorActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeResourcesSelectorActivity(): ResourceSelectorActivity

    @ContributesAndroidInjector
    abstract fun contributeResourceDetailsActivity(): ResourceDetailsActivity

    @ContributesAndroidInjector
    abstract fun contributePlainProcessingActivity(): PlainProcessingActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeFailstackSimulatorActivity(): FailstackSimulatorActivity

    @ContributesAndroidInjector
    abstract fun contributeBossSettingsActivity(): BossSettingsActivity
}