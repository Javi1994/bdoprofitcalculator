package jcaselles.bdoprofitcalculator.domain.interactor

import io.reactivex.Single
import jcaselles.bdoprofitcalculator.domain.repository.ResourceRepository
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import javax.inject.Inject

class RetrieveResourcesForSelectorInteractor @Inject constructor(private val resourceRepository: ResourceRepository) {
    fun invoke(): Single<MutableList<ResourceType>> {
        return resourceRepository.getResourceTypesForSelector()
            .firstOrError()
    }
}