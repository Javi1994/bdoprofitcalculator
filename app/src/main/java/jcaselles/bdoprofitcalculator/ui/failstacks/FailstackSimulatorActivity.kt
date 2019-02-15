package jcaselles.bdoprofitcalculator.ui.failstacks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityFailstackSimulatorBinding
import jcaselles.bdoprofitcalculator.databinding.ActivityHomeBinding
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity
import jcaselles.bdoprofitcalculator.ui.processing.PlainProcessingActivity


class FailstackSimulatorActivity : BaseActivity() {

    private lateinit var binding: ActivityFailstackSimulatorBinding

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, FailstackSimulatorActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_failstack_simulator)

        setupToolbar(getString(R.string.failstack_simulator_toolbar_title))
    }
}
