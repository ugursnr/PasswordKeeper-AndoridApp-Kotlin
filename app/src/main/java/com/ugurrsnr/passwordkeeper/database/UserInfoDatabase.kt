
package com.ugurrsnr.passwordkeeper.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ugurrsnr.passwordkeeper.model.UserInformations


@Database(entities = arrayOf(UserInformations::class), version = 1, exportSchema = false)
abstract class UserInfoDatabase : RoomDatabase() {

    abstract fun userInfoDao() : UserInfoDao

    companion object {

        @Volatile private var INSTANCE : UserInfoDatabase? = null

        private val lock = Any()

        fun getDatabase(context: Context) : UserInfoDatabase{
            return INSTANCE?: synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserInfoDatabase::class.java,"info_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }

}

