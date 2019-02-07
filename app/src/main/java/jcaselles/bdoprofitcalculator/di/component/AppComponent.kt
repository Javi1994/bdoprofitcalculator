package jcaselles.bdoprofitcalculator.di.component

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjection
import jcaselles.bdoprofitcalculator.App
import jcaselles.bdoprofitcalculator.di.Injectable
import jcaselles.bdoprofitcalculator.di.module.ActivityModule
import jcaselles.bdoprofitcalculator.di.module.AppModule
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    object Initializer {
        fun init(app: App) {
            DaggerAppComponent.builder().application(app).build().inject(app)
            app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityPaused(activity: Activity?) {
                }

                override fun onActivityResumed(activity: Activity?) {
                }

                override fun onActivityStarted(activity: Activity?) {
                }

                override fun onActivityDestroyed(activity: Activity?) {
                }

                override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                }

                override fun onActivityStopped(activity: Activity?) {
                }

                override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                    handleActivity(activity)
                }

            })
        }

        private fun handleActivity(activity: Activity?) {
            if (activity is BaseActivity) {
                AndroidInjection.inject(activity)
                activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
                            super.onFragmentAttached(fm, f, context)
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true
                )
            }
        }
    }
}