package jcaselles.bdoprofitcalculator.domain.repository

import io.reactivex.Flowable
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import javax.inject.Inject

class ResourceRepository @Inject constructor() {
    fun getResourceTypesForSelector(): Flowable<MutableList<ResourceType>> {
        val types = mutableListOf<ResourceType>()
        types.add(ResourceType.ORE)
        types.add(ResourceType.PLANT)

        return Flowable.just(types)
    }
}