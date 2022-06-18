package com.ugurrsnr.passwordkeeper.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.ugurrsnr.passwordkeeper.model.UserInformations
import kotlinx.coroutines.CoroutineScope


@Dao
interface UserInfoDao {

    // Data Access Object

    @Insert(onConflict = IGNORE)
    fun insertSingleInfo(userInformation : UserInformations)

    @Delete
    fun deleteSingleInfo(userInformation: UserInformations)

    @Update
    fun updateInfo(userInformation: UserInformations)

    @Query("select * from informations order by informationId ASC")
    fun getAllInformations() : LiveData<List<UserInformations>>



}

