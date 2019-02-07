package jcaselles.bdoprofitcalculator.di.module

import com.payproapp.domain.executor.JobExecutor
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideThreadExecutor(): Scheduler {
        return Schedulers.from(JobExecutor())
    }
}