package ru.wootography.cryptotest.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.wootography.cryptotest.Const
import ru.wootography.cryptotest.api.endpoints.IStock
import ru.wootography.cryptotest.utils.presenter.TokenHelper


class RestApi(private val tokenHelper: TokenHelper) {

    val istock: IStock

    private val retrofit: Retrofit

    init {

        val interceptor = HttpLoggingInterceptor()
       // val tokenInterceptor = TokenAppendingHeaderInterceptor()
        //if backend have cookies instead token,compile 'com.github.franmontiel:PersistentCookieJar:v1.0.1'
        // and add .cookieJar(cookieJar) into OkHttpClient;
        // ClearableCookieJar cookieJar = new PersistentCookieJar(dataControl.getCookieCache(), dataControl.getSharedPrefsCookiePersistor());

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                //.addInterceptor(tokenInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()


        retrofit = Retrofit.Builder().baseUrl(Const.Url.API_TEST)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        istock = retrofit.create(IStock::class.java)
    }



    private inner class TokenAppendingHeaderInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

            val NO_AUTHORIZED = 401

            val request = chain.request()
            val token = tokenHelper.token
            val newRequest = request.newBuilder()
                    .addHeader(Const.Url.AUTHORIZATION, token)
                    .build()

            val response = chain.proceed(newRequest)
            if (response.code() == NO_AUTHORIZED) {
                // TODO: 18.10.2018  reload Application, and clear token or update token

            }
            return response
        }
    }

}
