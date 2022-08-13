package com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository

import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET


interface CurrencyApiInterface {

    @GET("api/latest.json")
    suspend fun convertCurrencyData(): Response<JSONObject>
}