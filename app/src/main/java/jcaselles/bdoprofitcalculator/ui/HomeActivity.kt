package jcaselles.bdoprofitcalculator.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityHomeBinding
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity
import jcaselles.bdoprofitcalculator.ui.bosses.BossSettingsActivity
import jcaselles.bdoprofitcalculator.ui.failstacks.FailstackSimulatorActivity
import jcaselles.bdoprofitcalculator.ui.processing.PlainProcessingActivity


class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setupListeners()

        setupToolbar(getString(R.string.home_toolbar_title))
    }

    private fun setupListeners() {
        binding.onProcessingScreenClick = View.OnClickListener {
            PlainProcessingActivity.start(this)
        }
        binding.onFailstackSimulatorClick = View.OnClickListener {
            FailstackSimulatorActivity.start(this)
        }
        binding.onBossSettingsClick = View.OnClickListener {
            BossSettingsActivity.start(this)
        }
    }
}
