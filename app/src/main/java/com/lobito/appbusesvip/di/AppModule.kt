package com.lobito.appbusesvip.di


import com.lobito.appbusesvip.data.repository.DataStoreRepositoryImpl
import com.lobito.appbusesvip.domain.repository.PreferencesRepository
import com.lobito.appbusesvip.data.repository.*
import com.lobito.appbusesvip.domain.repository.*

import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single(named(Qualifiers.privateKey)) { "private_key" }
    single(named(Qualifiers.publicKey)) { "public_key" }
    singleOf(::DataStoreRepositoryImpl) bind PreferencesRepository::class
    singleOf(::LoginRepositoryImpl) bind UserRepository::class
    singleOf(::TokenRepositoryImpl) bind TokenRepository::class
    singleOf(::AbsentismoRepositoryImpl) bind AbsentismoRepository::class
    singleOf(::InventoryRepositoryImpl) bind InventoryRepository::class
    singleOf(::IdentificadorRepositoryImpl) bind IdentificadorRepository::class
    singleOf(::SyncRepositoryImpl)

}

enum class Qualifiers {
    privateKey,
    publicKey,
    devBaseApiSecurityURL,
    prdBaseApiSecurityURL,
    devApiBusesURL,
    prdApiBusesURL,
    prdEmployeeURL,
    prdInventoryURL,
    prdDniURL,
    retrofitApiSecurity,
    retrofitApiBuses,
    retrofitEmployee,
    retrofitInventory,
    retrofitDNI,
    tokenSyncWorker,
    myDataStore,
    tokenBuses,
    tokenSecurity,
    tokenEmployee,
    tokenInventory,
    interceptorBuses,
    interceptorEmployee,
    interceptorSecurity,
    interceptorInventory,
    interceptorDNI,
    okHttpSecurity,
    okHttpBuses,
    okHttpEmployee,
    okHttpInventory,
    okHttpDNI,

}

//fun provideSharedPreferencesRepository(context: Context): SharedPreferencesRepositoryImpl {
//    return SharedPreferencesRepositoryImpl(context)
//}
