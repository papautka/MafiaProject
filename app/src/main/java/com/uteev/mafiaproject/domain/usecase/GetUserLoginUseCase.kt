package com.uteev.mafiaproject.domain.usecase

import com.uteev.mafiaproject.domain.modules.LoginName
import com.uteev.mafiaproject.domain.repository.UserRepository

class GetUserLoginUseCase(private val userRepository: UserRepository) {
    suspend fun execute(login : String) : LoginName {
        return userRepository.getUserLogin(login)
    }
}