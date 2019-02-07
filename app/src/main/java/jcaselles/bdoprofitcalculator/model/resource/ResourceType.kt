package jcaselles.bdoprofitcalculator.model.resource

import jcaselles.bdoprofitcalculator.R

enum class ResourceType {
    ORE(),
    PLANT();

    fun getResourceImage(): Int {
        return when (this) {
            ResourceType.PLANT -> R.drawable.ic_pine_plywood
            ResourceType.ORE -> R.drawable.ic_iron_ingot
        }
    }
}