package jcaselles.bdoprofitcalculator.ui.selector

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ActivityResourceSelectorBinding
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import jcaselles.bdoprofitcalculator.model.resource.ResourceType.ORE
import jcaselles.bdoprofitcalculator.model.resource.ResourceType.PLANT
import jcaselles.bdoprofitcalculator.ui.base.BaseActivity

class ResourceSelectorActivity : BaseActivity() {

    lateinit var binding: ActivityResourceSelectorBinding
    lateinit var viewModel: ResourceSelectorViewModel

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

        viewModel.resourceTypes.observe(this, Observer { resourceType ->
            loadResourceTypes(resourceType)
        })

        viewModel.retrieveResourceTypes()
    }

    @SuppressLint("SetTextI18n")
    private fun loadResourceTypes(resourceTypes: MutableList<ResourceType>) {
        for (resourceType in resourceTypes) {
            when (resourceType) {
                ORE -> {
                    binding.test.text = binding.test.text.toString() + "ORE"
                }
                PLANT -> {
                    binding.test.text = binding.test.text.toString() + " - PLANT"
                }
            }
        }
    }
}
