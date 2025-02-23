package com.lobito.eatidentifiervip.di


import com.lobito.eatidentifiervip.data.repository.DataStoreRepositoryImpl
import com.lobito.eatidentifiervip.domain.repository.PreferencesRepository
import com.lobito.eatidentifiervip.data.repository.*
import com.lobito.eatidentifiervip.domain.repository.*

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

    // EAT IDENTIFIER
    singleOf(::EmpresaRepositoryImpl) bind EmpresaRepository::class
    singleOf(::EmpleadoRepositoryImpl) bind EmpleadoRepository::class

}

enum class Qualifiers {
    prdEatIdentifierURL,
    tokenEatIdentifier,
    okHttpEatIdentifier,
    retrofitEatIdentifier,
    interceptorEatIdentifier,

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
