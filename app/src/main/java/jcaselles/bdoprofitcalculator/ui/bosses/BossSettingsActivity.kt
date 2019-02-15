package jcaselles.bdoprofitcalculator.ui.bosses

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityBossSettingsBinding
import jcaselles.bdoprofitcalculator.model.Bosses
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity


class BossSettingsActivity : BaseActivity() {

    private lateinit var binding: ActivityBossSettingsBinding
    private lateinit var viewModel: BossesViewModel

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, BossSettingsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_boss_settings)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(BossesViewModel::class.java)

        setupToolbar(getString(R.string.boss_settings_toolbar_title))
    }

    private fun loadBosses() {
        val bosses = mutableListOf<Bosses>()
        bosses.add(Bosses.KZARKA)

        viewModel.initializeBossAlarms()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bosses_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                loadBosses()
                Toast.makeText(this, "Boss Settings Saved", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
