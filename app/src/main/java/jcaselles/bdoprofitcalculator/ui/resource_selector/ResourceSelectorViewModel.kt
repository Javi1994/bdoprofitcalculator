package jcaselles.bdoprofitcalculator.ui.resource_selector

import androidx.lifecycle.MutableLiveData
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import jcaselles.bdoprofitcalculator.domain.interactor.RetrieveResourcesForSelectorInteractor
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import jcaselles.bdoprofitcalculator.ui.base.BaseViewModel
import javax.inject.Inject

class ResourceSelectorViewModel @Inject constructor(
    private val retrieveResourcesForSelectorInteractor: RetrieveResourcesForSelectorInteractor,
    private val executor: Scheduler
) : BaseViewModel() {

    val resourceTypes: MutableLiveData<MutableList<ResourceType>> = MutableLiveData()

    fun retrieveResourceTypes() {
        disposable.add(
            retrieveResourcesForSelectorInteractor.invoke()
                .subscribeOn(executor)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isNotEmpty()) {
                        resourceTypes.value = it
                    }
                }, {
                })
        )
    }
}