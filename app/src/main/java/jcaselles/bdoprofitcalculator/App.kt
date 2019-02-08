package jcaselles.bdoprofitcalculator

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import jcaselles.bdoprofitcalculator.di.component.AppComponent
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        AppComponent.Initializer.init(this)
    }

    override fun activityInjector() = dispatchingActivityInjector
}