package com.uteev.mafiaproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDbDao {
    @Query("SELECT * FROM usersdbmodel")
    fun getAllUsers(): LiveData<List<UsersDbModel>>

    @Query("SELECT * FROM usersdbmodel WHERE login = :login")
    fun getUser(login: String): LiveData<UsersDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UsersDbModel)

    @Query("DELETE FROM usersdbmodel WHERE login = :login")
    fun deleteUser(login: String)

    @Query("UPDATE usersdbmodel SET yesNoWin = :yesNoWin WHERE login = :login")
    fun updateYesNoWin(login: String, yesNoWin: Int)

    @Query("UPDATE usersdbmodel SET yesNoWin = :yesNoWin, extraPoints = :extraPoints WHERE login = :login")
    fun updateYesNoWinAndExtraPoints(login: String, yesNoWin: Int, extraPoints: Double)
}