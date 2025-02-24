package com.lobito.eatidentifiervip.di

import android.content.Context
import androidx.room.Room
import com.lobito.eatidentifiervip.data.local.dao.AbsentismoDao
import com.lobito.eatidentifiervip.data.local.dao.EmpresaDao
import com.lobito.eatidentifiervip.data.local.dao.InventoryDao
import com.lobito.eatidentifiervip.data.local.dao.SessionDao
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
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().absentismoDao() }
    single { get<AppDatabase>().inventoryDao() }

    //EAT IDENTIFIER VIP
    single { get<AppDatabase>().empresaDao() }
    single { get<AppDatabase>().sessionDao() }
    single { get<AppDatabase>().empleadoDao() }
}