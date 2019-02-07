package jcaselles.bdoprofitcalculator.ui.resource_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityResourceDetailsBinding
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity

class ResourceDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityResourceDetailsBinding
    private lateinit var viewModel: ResourceDetailsViewModel

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ResourceDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resource_details)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ResourceDetailsViewModel::class.java)

        setupToolbar(getString(R.string.resource_details_toolbar_title))
    }
}
