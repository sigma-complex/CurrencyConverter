package com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository

import android.content.SharedPreferences
import android.util.Log
import com.hiddendimension.currencyconverter.feature_currency_conversion.data.util.CurrencyResponseServiceHelper
import org.json.JSONObject
import javax.inject.Inject

class CurrencyRepository @Inject constructor(
    private val api: CurrencyApiInterface,
    private val sharedPreferences: SharedPreferences
) : CurrencyRepositoryInterface {

    override suspend fun getExchangedAmount(): Resource<JSONObject> {


        val obj = JSONObject(sharedPreferences.getString("obj", "{}").toString())

        Log.d("shared pref", obj.toString())

        //put it on latest data for cache if available
        if (obj.has("timestamp")) {
            CurrencyResponseServiceHelper.json = obj.toString()
            CurrencyResponseServiceHelper.jsonObject = obj
            CurrencyResponseServiceHelper.makeCurrencyHashMap()

            Log.d("after time stamp check", obj.toString())
        }

        return try {


            if(CurrencyResponseServiceHelper.timeToRefresh()) {
                val response = api.convertCurrencyData()
                val result = response.body()

                result?.put("timestamp", System.currentTimeMillis() / 1000)

                Log.d("api >>", response.toString())
                Log.d("api >>", result.toString())

                if (response.isSuccessful && result != null) {

                    val editor = sharedPreferences.edit()
                    editor.putString("obj", result.toString())
                    editor.apply()

                    Resource.Success(result)


                } else {

                    Log.d("error >>", response.toString())
                    Log.d("error >>", response.body().toString())
                   // Resource.Error(response.message())
                    //Trying to load from cache
                    Resource.Success(CurrencyResponseServiceHelper.jsonObject)
                }

            }
            else{
                Resource.Success(CurrencyResponseServiceHelper.jsonObject)
            }



        } catch (e: Exception) {

            Log.d(" final error >>", e.message.toString())
            //Trying to load from cache
            Resource.Success(CurrencyResponseServiceHelper.jsonObject)

            //Resource.Error(e.message ?: "An error occurred")
        }

    }



}