package jcaselles.bdoprofitcalculator.ui.processing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityPlainProcessingBinding
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity


class PlainProcessingActivity : BaseActivity() {

    private lateinit var binding: ActivityPlainProcessingBinding
    private lateinit var viewModel: PlainProcessingViewModel

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, PlainProcessingActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_plain_processing)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PlainProcessingViewModel::class.java)
        binding.viewModel = viewModel

        setupToolbar(getString(R.string.plain_processing_toolbar_title))
    }
}
