package com.lobito.eatidentifiervip.di

import android.content.Context
import androidx.room.Room
import com.lobito.eatidentifiervip.data.local.database.AppDatabase
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(
            get<Context>().applicationContext,
            AppDatabase::class.java,
            "EatIdentifierVIP.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    //EAT IDENTIFIER VIP
    single { get<AppDatabase>().empresaDao() }
    single { get<AppDatabase>().sessionDao() }
    single { get<AppDatabase>().empleadoDao() }
    single { get<AppDatabase>().configuracionLocalDao() }
    single { get<AppDatabase>().configuracionGlobalDao() }
    single { get<AppDatabase>().historicoImpresionDao() }

}