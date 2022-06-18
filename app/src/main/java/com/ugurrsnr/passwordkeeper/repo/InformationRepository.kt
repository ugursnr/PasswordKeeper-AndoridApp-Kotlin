package com.ugurrsnr.passwordkeeper.repo

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.ugurrsnr.passwordkeeper.database.UserInfoDao
import com.ugurrsnr.passwordkeeper.model.UserInformations

class InformationRepository(private val userDao : UserInfoDao) {


    val getAllInformations : LiveData<List<UserInformations>> = userDao.getAllInformations()

    fun insertSingleInfo(userInformation : UserInformations){
        userDao.insertSingleInfo(userInformation)
    }

    fun updateInfo(userInformation: UserInformations){
        userDao.updateInfo(userInformation)
    }

    fun deleteSingleInfo(userInformation: UserInformations){
        userDao.deleteSingleInfo(userInformation)
    }

}