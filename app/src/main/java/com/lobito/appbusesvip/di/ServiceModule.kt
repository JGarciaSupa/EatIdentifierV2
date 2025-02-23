package com.lobito.appbusesvip.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.lobito.appbusesvip.data.remote.service.AppbusesService
import org.koin.androidx.workmanager.dsl.workerOf
import com.lobito.appbusesvip.data.remote.worker.TokenSyncWorker

val serviceModule = module {
//    singleOf(::AppbusesService) // Se pasa la referencia del constructor directamen
    singleOf(::AppbusesService)
    workerOf(::TokenSyncWorker)
//    single { PrintQueueManager() }
//    single<PrinterCommand>(named(Constants.BLUETOOTH)) { PrinterBluetoothCommandHandler(printQueueManager = get(), getPreferenceUseCase = get()) }
//    single<PrinterCommand>(named(Constants.RED)) { PrinterRedCommandHandler(get()) }
//    single<PrinterCommand>(named(Constants.POS)) { PrinterPOSCommandHandler(get()) }
}