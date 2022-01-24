package com.test.africafordata.room.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.test.africafordata.model.User


@Dao
interface UserDao {


    @Insert
    fun insert(user: User)


    @Update
    fun update(user: User)

    @Query("SELECT * FROM tbl_users LIMIT 1")
    fun getUser(): LiveData<User>
}