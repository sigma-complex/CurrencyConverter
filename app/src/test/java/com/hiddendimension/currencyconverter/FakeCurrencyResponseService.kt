package com.hiddendimension.currencyconverter

import org.json.JSONObject

class FakeCurrencyResponseService {

    fun latest(


    ): JSONObject {

        return JSONObject(
            "{\n" +
                    "    \"disclaimer\": \"Usage subject to terms: https://openexchangerates.org/terms\",\n" +
                    "    \"license\": \"https://openexchangerates.org/license\",\n" +
                    "    \"timestamp\": 1660345202,\n" +
                    "    \"base\": \"USD\",\n" +
                    "    \"rates\": {\n" +
                    "      \"AED\": 3.673015,\n" +
                    "      \"AFN\": 88.999995,\n" +
                    "      \"ALL\": 114.2,\n" +
                    "      \"AMD\": 404.828487,\n" +
                    "      \"ANG\": 1.801896,\n" +
                    "      \"AOA\": 429.295,\n" +
                    "      \"ARS\": 134.544684,\n" +
                    "      \"AUD\": 1.403184,\n" +
                    "      \"AWG\": 1.8,\n" +
                    "      \"AZN\": 1.7,\n" +
                    "      \"BAM\": 1.900063,\n" +
                    "      \"BBD\": 2,\n" +
                    "      \"BDT\": 94.992488,\n" +
                    "      \"BGN\": 1.906567,\n" +
                    "      \"BHD\": 0.376871,\n" +
                    "      \"BIF\": 2047,\n" +
                    "      \"BMD\": 1,\n" +
                    "      \"BND\": 1.371046,\n" +
                    "      \"BOB\": 6.903707,\n" +
                    "      \"BRL\": 5.0764,\n" +
                    "      \"BSD\": 1,\n" +
                    "      \"BTC\": 0.000041295688,\n" +
                    "      \"BTN\": 79.590321,\n" +
                    "      \"BWP\": 12.435517,\n" +
                    "      \"BYN\": 2.523146,\n" +
                    "      \"BZD\": 2.01535,\n" +
                    "      \"CAD\": 1.277625,\n" +
                    "      \"CDF\": 2001,\n" +
                    "      \"CHF\": 0.94159,\n" +
                    "      \"CLF\": 0.031782,\n" +
                    "      \"CLP\": 875.76,\n" +
                    "      \"CNH\": 6.735844,\n" +
                    "      \"CNY\": 6.7429,\n" +
                    "      \"COP\": 4242.61008,\n" +
                    "      \"CRC\": 668.917612,\n" +
                    "      \"CUC\": 1,\n" +
                    "      \"CUP\": 25.75,\n" +
                    "      \"CVE\": 107.875,\n" +
                    "      \"CZK\": 23.7312,\n" +
                    "      \"DJF\": 178.55,\n" +
                    "      \"DKK\": 7.24731,\n" +
                    "      \"DOP\": 54.05,\n" +
                    "      \"DZD\": 142.82381,\n" +
                    "      \"EGP\": 19.143661,\n" +
                    "      \"ERN\": 15,\n" +
                    "      \"ETB\": 52.23,\n" +
                    "      \"EUR\": 0.974417,\n" +
                    "      \"FJD\": 2.182,\n" +
                    "      \"FKP\": 0.823605,\n" +
                    "      \"GBP\": 0.823605,\n" +
                    "      \"GEL\": 2.705,\n" +
                    "      \"GGP\": 0.823605,\n" +
                    "      \"GHS\": 9.025,\n" +
                    "      \"GIP\": 0.823605,\n" +
                    "      \"GMD\": 54.15,\n" +
                    "      \"GNF\": 8800,\n" +
                    "      \"GTQ\": 7.738573,\n" +
                    "      \"GYD\": 209.178493,\n" +
                    "      \"HKD\": 7.8375,\n" +
                    "      \"HNL\": 24.569999,\n" +
                    "      \"HRK\": 7.3222,\n" +
                    "      \"HTG\": 127.976893,\n" +
                    "      \"HUF\": 381.965,\n" +
                    "      \"IDR\": 14661.076162,\n" +
                    "      \"ILS\": 3.23945,\n" +
                    "      \"IMP\": 0.823605,\n" +
                    "      \"INR\": 79.6278,\n" +
                    "      \"IQD\": 1460,\n" +
                    "      \"IRR\": 42350,\n" +
                    "      \"ISK\": 136.75,\n" +
                    "      \"JEP\": 0.823605,\n" +
                    "      \"JMD\": 151.796765,\n" +
                    "      \"JOD\": 0.709,\n" +
                    "      \"JPY\": 133.4365,\n" +
                    "      \"KES\": 119.45,\n" +
                    "      \"KGS\": 82.131352,\n" +
                    "      \"KHR\": 4112,\n" +
                    "      \"KMF\": 479.874687,\n" +
                    "      \"KPW\": 900,\n" +
                    "      \"KRW\": 1302.38,\n" +
                    "      \"KWD\": 0.306646,\n" +
                    "      \"KYD\": 0.833147,\n" +
                    "      \"KZT\": 477.165021,\n" +
                    "      \"LAK\": 15230,\n" +
                    "      \"LBP\": 1510.21338,\n" +
                    "      \"LKR\": 359.930184,\n" +
                    "      \"LRD\": 153.499994,\n" +
                    "      \"LSL\": 16.19,\n" +
                    "      \"LYD\": 4.865,\n" +
                    "      \"MAD\": 10.33375,\n" +
                    "      \"MDL\": 19.199464,\n" +
                    "      \"MGA\": 4204.205645,\n" +
                    "      \"MKD\": 59.770735,\n" +
                    "      \"MMK\": 2100.574002,\n" +
                    "      \"MNT\": 3170.209996,\n" +
                    "      \"MOP\": 8.071423,\n" +
                    "      \"MRU\": 37.59,\n" +
                    "      \"MUR\": 45.481782,\n" +
                    "      \"MVR\": 15.35,\n" +
                    "      \"MWK\": 1020,\n" +
                    "      \"MXN\": 19.82826,\n" +
                    "      \"MYR\": 4.4445,\n" +
                    "      \"MZN\": 63.899991,\n" +
                    "      \"NAD\": 16.19,\n" +
                    "      \"NGN\": 419.22,\n" +
                    "      \"NIO\": 36.24,\n" +
                    "      \"NOK\": 9.5664,\n" +
                    "      \"NPR\": 127.344178,\n" +
                    "      \"NZD\": 1.549295,\n" +
                    "      \"OMR\": 0.384832,\n" +
                    "      \"PAB\": 1,\n" +
                    "      \"PEN\": 3.8675,\n" +
                    "      \"PGK\": 3.525,\n" +
                    "      \"PHP\": 55.632003,\n" +
                    "      \"PKR\": 218.5,\n" +
                    "      \"PLN\": 4.536462,\n" +
                    "      \"PYG\": 6883.903199,\n" +
                    "      \"QAR\": 3.641,\n" +
                    "      \"RON\": 4.7609,\n" +
                    "      \"RSD\": 114.387115,\n" +
                    "      \"RUB\": 61.500005,\n" +
                    "      \"RWF\": 1028,\n" +
                    "      \"SAR\": 3.755135,\n" +
                    "      \"SBD\": 8.244163,\n" +
                    "      \"SCR\": 13.167393,\n" +
                    "      \"SDG\": 570,\n" +
                    "      \"SEK\": 10.20494,\n" +
                    "      \"SGD\": 1.37107,\n" +
                    "      \"SHP\": 0.823605,\n" +
                    "      \"SLL\": 13748.9,\n" +
                    "      \"SOS\": 569.833333,\n" +
                    "      \"SRD\": 24.28,\n" +
                    "      \"SSP\": 130.26,\n" +
                    "      \"STD\": 22392.090504,\n" +
                    "      \"STN\": 24.2,\n" +
                    "      \"SVC\": 8.748239,\n" +
                    "      \"SYP\": 2512.53,\n" +
                    "      \"SZL\": 16.19,\n" +
                    "      \"THB\": 35.310739,\n" +
                    "      \"TJS\": 10.203138,\n" +
                    "      \"TMT\": 3.51,\n" +
                    "      \"TND\": 3.135,\n" +
                    "      \"TOP\": 2.317889,\n" +
                    "      \"TRY\": 17.9363,\n" +
                    "      \"TTD\": 6.786807,\n" +
                    "      \"TWD\": 29.956503,\n" +
                    "      \"TZS\": 2332,\n" +
                    "      \"UAH\": 36.92466,\n" +
                    "      \"UGX\": 3817.184096,\n" +
                    "      \"USD\": 1,\n" +
                    "      \"UYU\": 40.199167,\n" +
                    "      \"UZS\": 10925,\n" +
                    "      \"VES\": 5.9402,\n" +
                    "      \"VND\": 23397.287196,\n" +
                    "      \"VUV\": 117.453513,\n" +
                    "      \"WST\": 2.69379,\n" +
                    "      \"XAF\": 639.175449,\n" +
                    "      \"XAG\": 0.04804115,\n" +
                    "      \"XAU\": 0.00055497,\n" +
                    "      \"XCD\": 2.70255,\n" +
                    "      \"XDR\": 0.732385,\n" +
                    "      \"XOF\": 639.175449,\n" +
                    "      \"XPD\": 0.00044962,\n" +
                    "      \"XPF\": 116.278841,\n" +
                    "      \"XPT\": 0.00103577,\n" +
                    "      \"YER\": 250.249937,\n" +
                    "      \"ZAR\": 16.16765,\n" +
                    "      \"ZMW\": 16.107058,\n" +
                    "      \"ZWL\": 322\n" +
                    "    }\n" +
                    "  }"
        )


    }

}