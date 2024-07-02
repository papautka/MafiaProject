package com.uteev.mafiaproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UsersDbModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    var login : String,
    // 0 - ведущий, 1 - мафия, 11 - дон, 2 - мирный, 22 - коммисар
    var role : Int = -1,
    // 0 - нет, 1 - да
    var yesNoWin : Int = -1,
    var extraPoints : Double = 0.0
)