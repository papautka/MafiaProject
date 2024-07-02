package com.uteev.mafiaproject.di

import com.uteev.mafiaproject.data.AppDatabase
import com.uteev.mafiaproject.data.UserRepositoryImpl
import com.uteev.mafiaproject.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserRepository> { UserRepositoryImpl(usersDbDao = get()) }
    single { get<AppDatabase>().usersListDao() }
}

