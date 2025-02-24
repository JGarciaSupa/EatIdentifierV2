package com.lobito.eatidentifiervip.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.lobito.eatidentifiervip.data.remote.service.AppService
import org.koin.androidx.workmanager.dsl.workerOf
import com.lobito.eatidentifiervip.data.remote.worker.TokenSyncWorker
import com.lobito.eatidentifiervip.domain.repository.PrinterRepository
import com.lobito.eatidentifiervip.data.printer.PrinterManager
import com.lobito.eatidentifiervip.data.printer.bluetooth.*
import com.lobito.eatidentifiervip.data.printer.network.*
import com.lobito.eatidentifiervip.data.printer.usb.*
import com.lobito.eatidentifiervip.data.repository.*
import org.koin.dsl.bind

val serviceModule = module {
//    singleOf(::AppbusesService) // Se pasa la referencia del constructor directamen
    singleOf(::AppService)
    workerOf(::TokenSyncWorker)

    ////SERVICIO DE PRINT DE TICKETS////
//    singleOf(::EmpleadoRepositoryImpl) bind EmpleadoRepository::class
    singleOf(::PrinterRepositoryImpl) bind PrinterRepository::class
    singleOf(::PrinterManager)
    singleOf(::BluetoothPrinter)
    singleOf(::NetworkPrinter)
    singleOf(::UsbPrinter)

//    single { PrintQueueManager() }
//    single<PrinterCommand>(named(Constants.BLUETOOTH)) { PrinterBluetoothCommandHandler(printQueueManager = get(), getPreferenceUseCase = get()) }
//    single<PrinterCommand>(named(Constants.RED)) { PrinterRedCommandHandler(get()) }
//    single<PrinterCommand>(named(Constants.POS)) { PrinterPOSCommandHandler(get()) }
}