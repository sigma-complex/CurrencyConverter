package com.hiddendimension.currencyconverter.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.*
import com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository.CurrencyApiInterface
import com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository.CurrencyRepository
import com.hiddendimension.currencyconverter.feature_currency_conversion.data.repository.CurrencyRepositoryInterface
import com.hiddendimension.currencyconverter.feature_currency_conversion.domain.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Singleton


private const val BASE_URL = "https://openexchangerates.org/"


class TokenInterceptor(private val preferencesStorage: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val token = preferencesStorage
        val url = original.url.newBuilder().addQueryParameter("app_id", token).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}


private fun buildGsonConverter(): GsonConverterFactory{
    val gsonBuilder = GsonBuilder()

    // Adding custom deserializers
    gsonBuilder.registerTypeAdapter(JSONObject::class.java, MyDeserializer())
    val myGson = gsonBuilder.create()
    return GsonConverterFactory.create(myGson)
}

class MyDeserializer : JsonDeserializer<JSONObject> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): JSONObject {


        return JSONObject( json.toString() )


    }

}


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    private val client = OkHttpClient.Builder()
        .addInterceptor(TokenInterceptor("e01308b510874422a543e00760c56a84"))
        .build()


    @Singleton
    @Provides
    fun provideCurrencyApi(): CurrencyApiInterface = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(buildGsonConverter())
        .build()
        .create(CurrencyApiInterface::class.java)


    @Singleton
    @Provides
    fun provideMainRepository(api: CurrencyApiInterface, sharedPreferences: SharedPreferences): CurrencyRepositoryInterface =
        CurrencyRepository(api, sharedPreferences)

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }


    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("currency", Context.MODE_PRIVATE)
    }
}