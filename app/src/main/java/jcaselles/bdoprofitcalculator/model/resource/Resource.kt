package jcaselles.bdoprofitcalculator.model.resource

import jcaselles.bdoprofitcalculator.model.resource.ResourceGrade
import jcaselles.bdoprofitcalculator.model.resource.ResourceType

data class Resource(
    private val name: String,
    private val resourceType: ResourceType,
    private val resourceGrade: ResourceGrade,
    private val minValue: Int,
    private val maxValue: Int,
    private val isProcesable: Boolean
)