package jcaselles.bdoprofitcalculator.ui.processing

import androidx.databinding.ObservableField
import jcaselles.bdoprofitcalculator.ui.base.BaseViewModel
import javax.inject.Inject

class PlainProcessingViewModel @Inject constructor() : BaseViewModel() {

    val quantity: ObservableField<String> = ObservableField("500")
    val time: ObservableField<String> = ObservableField("10")
    val t2_made: ObservableField<String> = ObservableField("260")
    val t3_made: ObservableField<String> = ObservableField("3")

    val t1_price: ObservableField<String> = ObservableField()
    val t2_price: ObservableField<String> = ObservableField()
    val t3_price: ObservableField<String> = ObservableField()

    val profitPerT2: ObservableField<String> = ObservableField()
    val profitPerT3: ObservableField<String> = ObservableField()

    val profitPerHour: ObservableField<String> = ObservableField()

    fun calculateProfits() {
        val quantityValue = getValueFromString(quantity.get())

        val t2Price = getValueFromString(t2_price.get())
        val t3Price = getValueFromString(t3_price.get())

        val t2MadeValue = (quantityValue / 1.92).toInt()
        val t3MadeValue = (quantityValue / 166.11).toInt()

        val profitPerT2Value = t2Price * t2MadeValue
        val profitPerT3Value = t3Price * t3MadeValue
        val profitPerHourValue = (profitPerT2Value + profitPerT3Value) * 6

        t2_made.set(t2MadeValue.toString())
        t3_made.set(t3MadeValue.toString())

        profitPerT2.set(profitPerT2Value.toString())
        profitPerT3.set(profitPerT3Value.toString())
        profitPerHour.set(profitPerHourValue.toString())
    }

    private fun getValueFromString(text: String?): Int {
        text?.let {
            return if (it == "" || it == " ") {
                0
            } else {
                it.toInt()
            }
        } ?: return 0
    }
}