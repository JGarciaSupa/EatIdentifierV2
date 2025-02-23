package com.lobito.eatidentifiervip.di

import com.lobito.eatidentifiervip.domain.usecase.token.*
import com.lobito.eatidentifiervip.domain.usecase.user.*
import com.lobito.eatidentifiervip.domain.usecase.shared.*
import com.lobito.eatidentifiervip.domain.usecase.dataInit.*
import com.lobito.eatidentifiervip.domain.usecase.empresas.*
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::PostLoginUseCase)
    factoryOf(::TokenSecurityUseCase)
    factoryOf(::TokenEmployeeUseCase)
    factoryOf(::GetPreferenceUseCase)
    factoryOf(::SetPreferenceUseCase)
    factoryOf(::GetAbsentismoUseCase)
    factoryOf(::UpdateAbsentismoUseCase)
    factoryOf(::TokenInventoryUseCase)
    factoryOf(::GetInventoryUseCase)
    factoryOf(::UpdateInventoryUseCase)
    factoryOf(::GetIdentificadorUseCase)
    factoryOf(::TokenBusesUseCase)

    //EAT IDENTIFIER
    factoryOf(::GetEmpresasUseCase)
}
