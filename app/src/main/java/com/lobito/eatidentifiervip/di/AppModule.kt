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

    singleOf(::DataStoreRepositoryImpl) bind PreferencesRepository::class // DATA STORE
    singleOf(::LoginRepositoryImpl) bind UserRepository::class
    singleOf(::IdentificadorRepositoryImpl) bind IdentificadorRepository::class
    singleOf(::SyncRepositoryImpl)
    singleOf(::EmpresaRepositoryImpl) bind EmpresaRepository::class
    singleOf(::EmpleadoRepositoryImpl) bind EmpleadoRepository::class
    singleOf(::ConfiguracionGlobalRepositoryImpl) bind ConfiguracionGlobalRepository::class
    singleOf(::ConfiguracionLocalRepositoryImpl) bind ConfiguracionLocalRepository::class


}

enum class Qualifiers {
    prdEatIdentifierURL,
    tokenEatIdentifier,
    okHttpEatIdentifier,
    retrofitEatIdentifier,
    interceptorEatIdentifier,
    privateKey,
    publicKey,
    prdDniURL,
    retrofitDNI,
    tokenSyncWorker,
    myDataStore,
    interceptorDNI,
    okHttpDNI,

}

enum class PrinterType {
    BLUETOOTH, NETWORK, USB
}