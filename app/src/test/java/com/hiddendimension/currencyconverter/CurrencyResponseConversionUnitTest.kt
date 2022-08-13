package com.hiddendimension.currencyconverter

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class CurrencyResponseConversionUnitTest {

    private val latest = FakeCurrencyResponseService().latest()

    private val oneUSDToTargetCurrency: HashMap<String, Double> = HashMap()

    private val oneCurrencyToUSD: HashMap<String, Double> = HashMap()

    @Test
    fun `base is USD`() {


        assertThat(latest.get("base")).isEqualTo("USD")

    }


    @Test
    fun `make currency hashmaps and convert BDT TO INR`() {

        val rates = latest.getJSONObject("rates")

        rates.keys().forEach {
            oneUSDToTargetCurrency[it] = rates.getDouble(it)
        }


        oneUSDToTargetCurrency.forEach { (k, _) ->
            oneCurrencyToUSD[k] = 1 / oneUSDToTargetCurrency[k]!!
        }



        assertThat(convert("BDT", "INR", 100.0)).isAtLeast(83)

    }


    private fun convert(fromCurrency: String, toCurrency: String, amount: Double): Double {
        return oneCurrencyToUSD[fromCurrency]!! * amount * oneUSDToTargetCurrency[toCurrency]!!
    }


    @Test
    fun lastResponseTime() {
        val x = System.currentTimeMillis() / 1000
        assertThat((x - 1660345202) / 3600).isAtLeast(7)
    }

    @Test
    fun `at least 30 minutes has been elapsed`(){
        val x = System.currentTimeMillis() / 1000

            assertThat(((x - 1660384807) / 60)).isAtLeast(30)
    }

}