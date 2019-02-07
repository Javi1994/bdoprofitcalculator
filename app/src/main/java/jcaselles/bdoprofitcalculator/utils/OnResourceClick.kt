package jcaselles.bdoprofitcalculator.utils

import jcaselles.bdoprofitcalculator.model.resource.ResourceType

interface OnResourceClick {
    fun onResourceSelected(resourceType: ResourceType)
}