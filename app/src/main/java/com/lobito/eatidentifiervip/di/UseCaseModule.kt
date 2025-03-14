package com.lobito.eatidentifiervip.di


import com.lobito.eatidentifiervip.domain.usecase.user.*
import com.lobito.eatidentifiervip.domain.usecase.shared.*
import com.lobito.eatidentifiervip.domain.usecase.dataInit.*
import com.lobito.eatidentifiervip.domain.usecase.empresas.*
import com.lobito.eatidentifiervip.domain.usecase.empleados.*
import com.lobito.eatidentifiervip.domain.usecase.printer.*
import com.lobito.eatidentifiervip.domain.usecase.confGlobal.*
import com.lobito.eatidentifiervip.domain.usecase.confLocal.*
import com.lobito.eatidentifiervip.domain.usecase.ticket.*
import com.lobito.eatidentifiervip.domain.usecase.historico.*
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {

    factoryOf(::GetPreferenceUseCase)
    factoryOf(::SetPreferenceUseCase)
    factoryOf(::GetIdentificadorUseCase)

    //EAT IDENTIFIER
    factoryOf(::GetEmpresasUseCase)
    factoryOf(::GetEmpresasFromApiUseCase)
    factoryOf(::PostLoginUseCase)
    factoryOf(::LoginAutomaticUseCase)
    factoryOf(::GetEmpleadosFromDBUseCase)
    factoryOf(::GetEmpleadosFromApiUseCase)
    factoryOf(::GetEmpleadoByCuiUseCase)
    factoryOf(::InsertEmpleadoUseCase)
    factoryOf(::InsertEmpresasUseCase)
    factoryOf(::ConfiguracionLocalUseCase)
    factoryOf(::ConfiguracionGlobalUseCase)

    factoryOf(::PrintUseCase)
    factoryOf(::TicketPresentationUseCase)
    factoryOf(::TicketModelOneUseCase)
    factoryOf(::HistoricoImpresionUseCase)
    factoryOf(::GetHistoricoByEmpleadoUseCase)
}
