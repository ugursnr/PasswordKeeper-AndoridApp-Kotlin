package com.ugurrsnr.passwordkeeper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "informations")
data class UserInformations(


    @ColumnInfo(name = "websiteName")
    val websiteName : String,

    @ColumnInfo(name = "userID")
    val userId : String,

    @ColumnInfo(name = "userPassword")
    val userPassword : String,

) {
    @PrimaryKey(autoGenerate = true)
    var informationId: Int = 0

}