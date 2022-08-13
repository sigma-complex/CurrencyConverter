package com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository

import org.json.JSONObject

interface CurrencyRepositoryInterface {

    suspend fun getExchangedAmount(): Resource<JSONObject>
}