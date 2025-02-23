package com.lobito.eatidentifiervip.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.lobito.eatidentifiervip.data.remote.service.AppService
import org.koin.androidx.workmanager.dsl.workerOf
import com.lobito.eatidentifiervip.data.remote.worker.TokenSyncWorker

val serviceModule = module {
//    singleOf(::AppbusesService) // Se pasa la referencia del constructor directamen
    singleOf(::AppService)
    workerOf(::TokenSyncWorker)
//    single { PrintQueueManager() }
//    single<PrinterCommand>(named(Constants.BLUETOOTH)) { PrinterBluetoothCommandHandler(printQueueManager = get(), getPreferenceUseCase = get()) }
//    single<PrinterCommand>(named(Constants.RED)) { PrinterRedCommandHandler(get()) }
//    single<PrinterCommand>(named(Constants.POS)) { PrinterPOSCommandHandler(get()) }
}