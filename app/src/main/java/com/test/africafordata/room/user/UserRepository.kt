package com.test.africafordata.room.user

import android.app.Application
import androidx.lifecycle.LiveData
import com.test.africafordata.model.User
import com.test.africafordata.room.AppDatabase
import javax.inject.Inject


class UserRepository @Inject constructor(application: Application) {

    private val userDao: UserDao
    //private val TAG  = "UserRepository"

    private val user: LiveData<User>

    init {
        val userDatabase =
            AppDatabase(application)
        userDao = userDatabase.userDao()
        user = userDao.getUser()
        //android.util.Log.d(TAG,"${user.value?.firstName}")
    }


    fun insert(user: User) {
        userDao.insert(user)
    }

    fun update(user: User) {
        userDao.update(user)
    }


    fun getUser() = user


}