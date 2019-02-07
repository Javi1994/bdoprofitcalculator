package jcaselles.bdoprofitcalculator.ui.resource_selector

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jcaselles.bdoprofitcalculator.R
import jcaselles.bdoprofitcalculator.databinding.ItemResourceSelectorBinding
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import jcaselles.bdoprofitcalculator.utils.OnResourceClick

class ResourceSelectorAdapter(private val onResourceClick: OnResourceClick) : RecyclerView.Adapter<ResourceSelectorAdapter.Companion.ResourceSelectorViewHolder>() {
    private var resourcesTypes: MutableList<ResourceType> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceSelectorViewHolder {
        val bindingBalance = DataBindingUtil.inflate<ItemResourceSelectorBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_resource_selector,
                parent,
                false)

        return ResourceSelectorViewHolder(bindingBalance, onResourceClick)
    }

    override fun onBindViewHolder(holder: ResourceSelectorViewHolder, position: Int) {
        holder.bind(resourcesTypes[position])
    }

    override fun getItemCount(): Int {
        return resourcesTypes.size
    }

    companion object {
        class ResourceSelectorViewHolder(private val binding: ItemResourceSelectorBinding,
                                         private val onResourceSelected: OnResourceClick) : RecyclerView.ViewHolder(binding.root) {
            fun bind(resourceType: ResourceType) {
                binding.resource = resourceType
                binding.onResourceClick = View.OnClickListener {
                    onResourceSelected.onResourceSelected(resourceType)
                }
            }
        }
    }

    fun clear() {
        resourcesTypes.clear()
        notifyDataSetChanged()
    }

    fun addAll(list: List<ResourceType>) {
        resourcesTypes.addAll(list)
        notifyDataSetChanged()
    }
}