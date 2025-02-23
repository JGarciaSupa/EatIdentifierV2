package com.lobito.appbusesvip.di

import com.lobito.appbusesvip.domain.usecase.token.*
import com.lobito.appbusesvip.domain.usecase.user.*
import com.lobito.appbusesvip.domain.usecase.shared.*
import com.lobito.appbusesvip.domain.usecase.dataInit.*
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
}
