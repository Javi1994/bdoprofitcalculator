package jcaselles.bdoprofitcalculator.ui.bosses

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityBossSettingsBinding
import jcaselles.bdoprofitcalculator.databinding.ActivityHomeBinding
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity
import jcaselles.bdoprofitcalculator.ui.processing.PlainProcessingActivity


class BossSettingsActivity : BaseActivity() {

    private lateinit var binding: ActivityBossSettingsBinding

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, BossSettingsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_boss_settings)

        setupToolbar(getString(R.string.boss_settings_toolbar_title))
    }
}
