package com.uteev.mafiaproject.di

import com.uteev.mafiaproject.data.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { AppDatabase.getInstance(get()) }
}
