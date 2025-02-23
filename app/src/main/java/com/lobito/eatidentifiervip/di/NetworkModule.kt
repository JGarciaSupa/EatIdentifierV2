package com.lobito.eatidentifiervip.di

import com.lobito.eatidentifiervip.BuildConfig
import com.lobito.eatidentifiervip.data.common.Constants
import com.lobito.eatidentifiervip.data.remote.apis.EmployeeApi
import com.lobito.eatidentifiervip.data.remote.apis.IdentificadorApi
import com.lobito.eatidentifiervip.data.remote.apis.InventoryApi
import com.lobito.eatidentifiervip.data.remote.apis.BusesApi
import com.lobito.eatidentifiervip.data.remote.apis.EatIdentifierApi
import com.lobito.eatidentifiervip.data.remote.apis.SecurityApi
import com.lobito.eatidentifiervip.data.remote.intereptor.BusesInterceptor
import com.lobito.eatidentifiervip.data.remote.intereptor.EatIdentifierInterceptor
import com.lobito.eatidentifiervip.data.remote.intereptor.EmployeeInterceptor
import com.lobito.eatidentifiervip.data.remote.intereptor.QueryInterceptor
import com.lobito.eatidentifiervip.data.remote.intereptor.SecurityInterceptor
import com.lobito.eatidentifiervip.data.remote.intereptor.InventoryInterceptor
import com.lobito.eatidentifiervip.di.Qualifiers.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    // DNI
    single(named(prdDniURL)) { BuildConfig.API_DNI_PROD }

    // Seguridad
    single(named(devBaseApiSecurityURL)) { BuildConfig.API_SEGURIDAD_DEV }
    single(named(prdBaseApiSecurityURL)) { BuildConfig.API_SEGURIDAD_PROD }

    // Buses
    single(named(devApiBusesURL)) { BuildConfig.API_BUSES_DEV }
    single(named(prdApiBusesURL)) { BuildConfig.API_BUSES_PROD }

    // Employee
    single(named(prdEmployeeURL)) { BuildConfig.API_EMPLOYEE_PROD }

    // Inventario
    single(named(prdInventoryURL)) { BuildConfig.API_INVENTARIO_PROD }

    // Eat Identifier
    single(named(prdEatIdentifierURL)) { BuildConfig.API_EATIDENTIFIER }

    // 🔹 Registrar HttpLoggingInterceptor en Koin
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<Interceptor>(named(interceptorDNI)) { // No Necesita Terminado
        QueryInterceptor(
            privateKey = get(named(Qualifiers.privateKey)),
            publicKey = get(named(Qualifiers.publicKey))
        )
    }

    single<Interceptor>(named(interceptorBuses)) {
        BusesInterceptor(get())
    }

    single<Interceptor>(named(interceptorEmployee)) {
        EmployeeInterceptor(get())
    }

    single<Interceptor>(named(interceptorSecurity)) {
        SecurityInterceptor(get())
    }

    single<Interceptor>(named(interceptorInventory)) {
        InventoryInterceptor(get())
    }

    single<Interceptor>(named(interceptorEatIdentifier)) { // EAT IDENTIFIER
       EatIdentifierInterceptor(get())
    }

    single(named(okHttpBuses)) {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>(named(interceptorBuses)))
            .build()
    }

    single(named(okHttpSecurity)) {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>(named(interceptorSecurity)))
            .build()
    }

    single(named(okHttpEmployee)) {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>(named(interceptorEmployee)))
            .build()
    }

    single(named(okHttpDNI)) {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
//            .addInterceptor(get<Interceptor>(named(interceptorDNI)))
            .build()
    }

    single(named(okHttpInventory)) {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>(named(interceptorInventory)))
            .build()
    }

    single(named(okHttpEatIdentifier)) { // EAT IDENTIFIER
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>(named(interceptorEatIdentifier)))
            .build()
    }

    // 🔹 Retrofit para TokenBusesApi
    single(named(retrofitApiSecurity)) {
        val baseUrl = if (Constants.isDebugModeON) {
            get<String>(named(devBaseApiSecurityURL))
        } else {
            get<String>(named(prdBaseApiSecurityURL))
        }

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpSecurity)))
            .build()
    }

    single(named(retrofitApiBuses)) {
        val baseUrl = if (Constants.isDebugModeON) {
            get<String>(named(devApiBusesURL))
        } else {
            get<String>(named(prdApiBusesURL))
        }

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpBuses)))
            .build()
    }

    single(named(retrofitEmployee)) {
        Retrofit.Builder()
            .baseUrl(get<String>(named(prdEmployeeURL)))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpEmployee)))
            .build()
    }

    single(named(retrofitDNI)) {
        Retrofit.Builder()
            .baseUrl(get<String>(named(prdDniURL)))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpDNI)))
            .build()
    }

    single(named(retrofitInventory)) {
        Retrofit.Builder()
            .baseUrl(get<String>(named(prdInventoryURL)))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpInventory)))
            .build()
    }

    single(named(retrofitEatIdentifier)) { //EAT IDENTIFIER
        Retrofit.Builder()
            .baseUrl(get<String>(named(prdEatIdentifierURL)))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpEatIdentifier)))
            .build()
    }

    single { get<Retrofit>(named(retrofitApiSecurity)).create(SecurityApi::class.java) }
    single { get<Retrofit>(named(retrofitApiBuses)).create(BusesApi::class.java) }
    single { get<Retrofit>(named(retrofitEmployee)).create(EmployeeApi::class.java) }
    single { get<Retrofit>(named(retrofitDNI)).create(IdentificadorApi::class.java) }
    single { get<Retrofit>(named(retrofitInventory)).create(InventoryApi::class.java) } //no se utiliza
    single { get<Retrofit>(named(retrofitEatIdentifier)).create(EatIdentifierApi::class.java) }
}
