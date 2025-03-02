package com.lobito.eatidentifiervip.di

import com.lobito.eatidentifiervip.BuildConfig
import com.lobito.eatidentifiervip.data.remote.apis.IdentificadorApi
import com.lobito.eatidentifiervip.data.remote.apis.EatIdentifierApi
import com.lobito.eatidentifiervip.data.remote.intereptor.EatIdentifierInterceptor
import com.lobito.eatidentifiervip.data.remote.intereptor.QueryInterceptor
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


    single<Interceptor>(named(interceptorEatIdentifier)) { // EAT IDENTIFIER
       EatIdentifierInterceptor(get())
    }


    single(named(okHttpDNI)) {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
//            .addInterceptor(get<Interceptor>(named(interceptorDNI)))
            .build()
    }


    single(named(okHttpEatIdentifier)) { // EAT IDENTIFIER
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>(named(interceptorEatIdentifier)))
            .build()
    }


    single(named(retrofitDNI)) {
        Retrofit.Builder()
            .baseUrl(get<String>(named(prdDniURL)))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpDNI)))
            .build()
    }



    single(named(retrofitEatIdentifier)) { //EAT IDENTIFIER
        Retrofit.Builder()
            .baseUrl(get<String>(named(prdEatIdentifierURL)))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(okHttpEatIdentifier)))
            .build()
    }

    single { get<Retrofit>(named(retrofitDNI)).create(IdentificadorApi::class.java) }
    single { get<Retrofit>(named(retrofitEatIdentifier)).create(EatIdentifierApi::class.java) }
}
