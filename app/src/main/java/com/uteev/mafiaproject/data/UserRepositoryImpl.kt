package com.uteev.mafiaproject.data

import android.util.Log
import com.uteev.mafiaproject.domain.modules.LoginName
import com.uteev.mafiaproject.domain.modules.SaveUserLoginParam
import com.uteev.mafiaproject.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(private val usersDbDao : UsersDbDao) : UserRepository {

    override suspend fun getUserLogin(login: String): LoginName {
        val user = usersDbDao.getUser(login).value

        // Проверяем, что пользователь не равен null
        return if (user != null) {
            LoginName(user.login, user.role)
        } else {
            // Обработка ситуации, когда пользователь не найден
            throw IllegalStateException("User not found for login: $login")
        }
    }

    override suspend fun saveUserLogin(param: SaveUserLoginParam): Boolean {
        return try {
            val newUser = UsersDbModel(
                id = 0,
                login = param.login,
                role = -1
            )
            withContext(Dispatchers.IO) {
                usersDbDao.addUser(newUser)
            }
            true
        } catch (e : Exception){
            Log.d("TAG", "saveUserLogin: ${e.message}")
            false
        }
    }
}