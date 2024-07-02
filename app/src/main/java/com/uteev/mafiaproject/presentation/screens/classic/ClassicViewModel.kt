package com.uteev.mafiaproject.presentation.screens.classic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uteev.mafiaproject.domain.modules.LoginName
import com.uteev.mafiaproject.domain.modules.SaveUserLoginParam
import com.uteev.mafiaproject.domain.usecase.GetUserLoginUseCase
import com.uteev.mafiaproject.domain.usecase.SaveUserLoginUseCase

class ClassicViewModel(
    private val getUserLoginUseCase: GetUserLoginUseCase,
    private val saveUserLoginUseCase: SaveUserLoginUseCase
) : ViewModel() {
    private var _resultLive : MutableLiveData<String> = MutableLiveData()
    val resultLive : MutableLiveData<String> = _resultLive

    suspend fun saveUserLogin (paramEditText : String) {
        val param = SaveUserLoginParam(paramEditText)
        val result = saveUserLoginUseCase.execute(param = param)
        _resultLive.value = result.toString()
    }

    suspend fun getUserLogin (login : String) {
        val result = getUserLoginUseCase.execute(login = login)
        _resultLive.value = result.toString()
    }

}