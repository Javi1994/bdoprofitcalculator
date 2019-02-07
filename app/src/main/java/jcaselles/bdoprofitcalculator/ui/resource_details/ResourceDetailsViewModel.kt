package jcaselles.bdoprofitcalculator.ui.resource_details

import io.reactivex.Scheduler
import jcaselles.bdoprofitcalculator.ui.base.BaseViewModel
import javax.inject.Inject

class ResourceDetailsViewModel @Inject constructor(
    private val executor: Scheduler
) : BaseViewModel() {

}