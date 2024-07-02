package com.uteev.mafiaproject.di

import com.uteev.mafiaproject.domain.usecase.GetUserLoginUseCase
import com.uteev.mafiaproject.domain.usecase.SaveUserLoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserLoginUseCase> { GetUserLoginUseCase(userRepository = get())}
    factory<SaveUserLoginUseCase> { SaveUserLoginUseCase(userRepository = get()) }
}