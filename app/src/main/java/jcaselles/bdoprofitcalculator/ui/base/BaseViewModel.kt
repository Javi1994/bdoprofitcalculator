package jcaselles.bdoprofitcalculator.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        if (disposable.isDisposed) {
            disposable.clear()
        }
    }
}