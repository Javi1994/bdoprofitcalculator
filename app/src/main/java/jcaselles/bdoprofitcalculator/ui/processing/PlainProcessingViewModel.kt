package jcaselles.bdoprofitcalculator.ui.processing

import androidx.databinding.ObservableField
import jcaselles.bdoprofitcalculator.ui.base.BaseViewModel
import javax.inject.Inject

class PlainProcessingViewModel @Inject constructor() : BaseViewModel() {

    private val T2_RATE = 1.92                  //requires 1,92 t1 to make a t2
    private val T3_RATE = 166.11                //requires 166,11 t1 to make a t3
    private val MARKETPLACE_STEALING = 1.18     //marketplace takes 11,8% from the original value when selling items

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

        val t1Price = getValueFromString(t1_price.get())
        val t2Price = getValueFromString(t2_price.get())
        val t3Price = getValueFromString(t3_price.get())

        val t1BuyingCount = t1Price * quantityValue
        val t2MadeValue = (quantityValue / T2_RATE).toInt()
        val t3MadeValue = (quantityValue / T3_RATE).toInt()

        val profitPerT2Value = (((t2Price * MARKETPLACE_STEALING) * t2MadeValue) * 6).toInt()
        val profitPerT3Value = (((t3Price * MARKETPLACE_STEALING) * t3MadeValue) * 6).toInt()
        val profitPerHourValue = profitPerT2Value + profitPerT3Value

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