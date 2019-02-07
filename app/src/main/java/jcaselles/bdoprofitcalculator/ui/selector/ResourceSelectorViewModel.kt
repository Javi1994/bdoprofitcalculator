package jcaselles.bdoprofitcalculator.ui.selector

import androidx.lifecycle.MutableLiveData
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import jcaselles.bdoprofitcalculator.ui.base.BaseViewModel
import javax.inject.Inject

class ResourceSelectorViewModel @Inject constructor() : BaseViewModel() {
    val resourceTypes: MutableLiveData<MutableList<ResourceType>> = MutableLiveData()

    fun retrieveResourceTypes() {
        val types = mutableListOf<ResourceType>()
        types.add(ResourceType.ORE)
        types.add(ResourceType.PLANT)

        resourceTypes.value = types
    }
}