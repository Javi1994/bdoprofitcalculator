package jcaselles.bdoprofitcalculator.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.app_bar_default.*
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected val disposable = CompositeDisposable()

    override fun onDestroy() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
        super.onDestroy()
    }

    fun setupToolbar(toolbarTitle: String) {
        setSupportActionBar(toolbar)
        title = toolbarTitle
    }
}