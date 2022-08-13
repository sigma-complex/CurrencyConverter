package com.hiddendimension.currencyconverter.feature_currency_conversion.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiddendimension.currencyconverter.feature_currency_conversion.data.util.CurrencyResponseServiceHelper
import com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository.CurrencyRepositoryInterface
import com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository.Resource
import com.hiddendimension.currencyconverter.feature_currency_conversion.domain.model.ItemsViewModel
import com.hiddendimension.currencyconverter.feature_currency_conversion.domain.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: CurrencyRepositoryInterface,
    private val dispatchers: DispatcherProvider,
) : ViewModel() {

    sealed class CurrencyEvent {
        class Success(val currencyList: ArrayList<ItemsViewModel>) : CurrencyEvent()
        class Failure(val errorText: String) : CurrencyEvent()
        object Loading : CurrencyEvent()
        object Empty : CurrencyEvent()
    }

    private val _conversion = MutableStateFlow<CurrencyEvent>(CurrencyEvent.Empty)
    val conversion: StateFlow<CurrencyEvent> = _conversion

    var data: ArrayList<ItemsViewModel>? = null

    init {
        data = ArrayList()
    }


    fun convert(
        amountStr: String,
        fromCurrency: String,
        arr: Array<out String>
    ) {

        val fromAmount = amountStr.toFloatOrNull()
        if (fromAmount == null) {
            _conversion.value = CurrencyEvent.Failure("Not a valid amount")
            return
        }

        viewModelScope.launch(dispatchers.io) {


            _conversion.value = CurrencyEvent.Loading


            when (val ratesResponse =
                repository.getExchangedAmount()) {

                is Resource.Error -> {
                    _conversion.value = CurrencyEvent.Failure(ratesResponse.message!!)

                }

                is Resource.Success -> {

                    CurrencyResponseServiceHelper.json = ratesResponse.data.toString()
                    CurrencyResponseServiceHelper.jsonObject = JSONObject(ratesResponse.data!!.toString())
                    CurrencyResponseServiceHelper.makeCurrencyHashMap()


                    data?.clear()

                    for (x in arr) {
                        data?.add(
                            ItemsViewModel(

                                "${
                                    String.format(
                                        "%.2f",
                                        CurrencyResponseServiceHelper.convert(
                                            fromCurrency,
                                            x,
                                            amountStr.toDouble()
                                        )
                                    )
                                } $x"

                            )
                        )
                    }

                    _conversion.value = CurrencyEvent.Success(data!!)
                }

            }
        }


    }

}


