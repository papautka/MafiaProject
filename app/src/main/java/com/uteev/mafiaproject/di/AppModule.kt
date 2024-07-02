package com.uteev.mafiaproject.di

import com.uteev.mafiaproject.presentation.screens.classic.ClassicViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        ClassicViewModel(
            getUserLoginUseCase = get(),
            saveUserLoginUseCase = get()
        )
    }
}