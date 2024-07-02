package com.uteev.mafiaproject.domain.usecase

import com.uteev.mafiaproject.domain.modules.SaveUserLoginParam
import com.uteev.mafiaproject.domain.repository.UserRepository

class SaveUserLoginUseCase(private val userRepository: UserRepository) {
    suspend fun execute(param : SaveUserLoginParam) : Boolean {
        return userRepository.saveUserLogin(param)
    }
}