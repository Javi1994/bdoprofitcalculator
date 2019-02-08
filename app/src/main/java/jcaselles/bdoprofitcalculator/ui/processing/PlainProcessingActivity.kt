package jcaselles.bdoprofitcalculator.ui.processing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityPlainProcessingBinding
import jcaselles.bdoprofitcalculator.databinding.ActivityResourceSelectorBinding
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity
import jcaselles.bdoprofitcalculator.ui.resource_details.ResourceDetailsActivity
import jcaselles.bdoprofitcalculator.ui.resource_selector.ResourceSelectorAdapter
import jcaselles.bdoprofitcalculator.ui.resource_selector.ResourceSelectorViewModel
import jcaselles.bdoprofitcalculator.utils.OnResourceClick
import jcaselles.bdoprofitcalculator.utils.SpaceItemDecoration

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

        setupToolbar(getString(R.string.plain_processing_toolbar_title))
    }
}
