package com.ugurrsnr.passwordkeeper.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ugurrsnr.passwordkeeper.database.UserInfoDatabase
import com.ugurrsnr.passwordkeeper.model.UserInformations
import com.ugurrsnr.passwordkeeper.repo.InformationRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class InformationViewModel(application: Application) : AndroidViewModel(application) {

    val userInformationList: LiveData<List<UserInformations>>
    private val userInfoRepository : InformationRepository
    val singleInformation = MutableLiveData<List<UserInformations>>()

    init{
        val dao = UserInfoDatabase.getDatabase(application).userInfoDao()
        userInfoRepository = InformationRepository(dao)
        userInformationList = userInfoRepository.getAllInformations

    }


    fun informationInsert(userInformation: UserInformations) = CoroutineScope(Dispatchers.IO).launch {
        userInfoRepository.insertSingleInfo(userInformation)
    }
    fun informationUpdate(userInformation: UserInformations) = CoroutineScope(Dispatchers.IO).launch {
        userInfoRepository.updateInfo(userInformation)
    }

    fun informationDelete(userInformation: UserInformations) = CoroutineScope(Dispatchers.IO).launch {
        userInfoRepository.deleteSingleInfo(userInformation)
    }
    fun informationRead(infoUUID : Int) = CoroutineScope(Dispatchers.IO).launch{
        val tempList = userInfoRepository.readSingleInfo(infoUUID)

        withContext(Dispatchers.Main){
            singleInformation.value = tempList

        }

    }


}