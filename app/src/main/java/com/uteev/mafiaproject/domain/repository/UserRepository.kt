package com.uteev.mafiaproject.domain.repository

import com.uteev.mafiaproject.domain.modules.LoginName
import com.uteev.mafiaproject.domain.modules.SaveUserLoginParam

interface UserRepository {
    suspend fun saveUserLogin(param : SaveUserLoginParam) : Boolean
    suspend fun getUserLogin(login : String) : LoginName
}