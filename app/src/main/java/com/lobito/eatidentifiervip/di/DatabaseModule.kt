package com.lobito.eatidentifiervip.di

import android.content.Context
import androidx.room.Room
import com.lobito.eatidentifiervip.data.local.dao.AbsentismoDao
import com.lobito.eatidentifiervip.data.local.dao.EmpresaDao
import com.lobito.eatidentifiervip.data.local.dao.InventoryDao
import com.lobito.eatidentifiervip.data.local.dao.UserDao
import com.lobito.eatidentifiervip.data.local.database.AppDatabase
import org.koin.dsl.module

val dataModule = module{
    single { provideDatabase(get()) }
    single { provideUserDao(get()) }
    single { providerAbsentismoDao(get()) }
    single { provideInventoryDao(get()) }
    single { provideEmpresaDao(get()) }
}


fun provideDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "AppbusesVIP.db"
    )
        .fallbackToDestructiveMigration()
        .build()
}

fun provideUserDao(database: AppDatabase): UserDao {
    return database.userDao()
}

fun providerAbsentismoDao(database: AppDatabase): AbsentismoDao {
    return database.absentismoDao()
}
fun provideInventoryDao(database: AppDatabase): InventoryDao {
    return database.inventoryDao()
}

fun provideEmpresaDao(database: AppDatabase): EmpresaDao {
    return database.empresaDao()
}