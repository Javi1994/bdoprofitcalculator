package jcaselles.bdoprofitcalculator.ui.resource_selector

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityResourceSelectorBinding
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity
import jcaselles.bdoprofitcalculator.ui.resource_details.ResourceDetailsActivity
import jcaselles.bdoprofitcalculator.utils.OnResourceClick
import jcaselles.bdoprofitcalculator.utils.SpaceItemDecoration

class ResourceSelectorActivity : BaseActivity() {

    private lateinit var binding: ActivityResourceSelectorBinding
    private lateinit var viewModel: ResourceSelectorViewModel

    private lateinit var resourcesSelectorAdapter: ResourceSelectorAdapter

    private val NUM_COLUMNS = 2

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ResourceSelectorActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resource_selector)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ResourceSelectorViewModel::class.java)

        setupToolbar(getString(R.string.resource_selector_toolbar_title))
        setupResourceSelectorRecycler()

        viewModel.resourceTypes.observe(this, Observer { resourcesType ->
            resourcesSelectorAdapter.addAll(resourcesType)
        })

        viewModel.retrieveResourceTypes()
    }

    private fun setupResourceSelectorRecycler() {
        resourcesSelectorAdapter = ResourceSelectorAdapter(onResourceClick = object : OnResourceClick {
            override fun onResourceSelected(resourceType: ResourceType) {
                ResourceDetailsActivity.start(this@ResourceSelectorActivity)
            }
        })
        binding.resourceSelectorRecycler.layoutManager = GridLayoutManager(this, NUM_COLUMNS)
        binding.resourceSelectorRecycler.adapter = resourcesSelectorAdapter
        binding.resourceSelectorRecycler.addItemDecoration(SpaceItemDecoration(30))
    }
}
