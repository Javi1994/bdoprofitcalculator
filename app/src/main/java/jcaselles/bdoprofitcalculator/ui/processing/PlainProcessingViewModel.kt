package jcaselles.bdoprofitcalculator.ui.processing

import androidx.lifecycle.MutableLiveData
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import jcaselles.bdoprofitcalculator.domain.interactor.RetrieveResourcesForSelectorInteractor
import jcaselles.bdoprofitcalculator.model.resource.ResourceType
import jcaselles.bdoprofitcalculator.ui.base.BaseViewModel
import javax.inject.Inject

class PlainProcessingViewModel @Inject constructor(
    private val executor: Scheduler
) : BaseViewModel() {

}