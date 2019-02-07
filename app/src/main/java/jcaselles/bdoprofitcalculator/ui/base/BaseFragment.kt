package jcaselles.bdoprofitcalculator.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable
import jcaselles.bdoprofitcalculator.di.Injectable
import javax.inject.Inject

abstract class BaseFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val disposable = CompositeDisposable()

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}