package com.test.africafordata.room.devices

import androidx.lifecycle.LiveData
import androidx.room.*
import com.test.africafordata.model.device.RollerShutter


@Dao
interface RollerShutterDao {


    @Insert
    fun insert(rollerShutter: RollerShutter)


    @Update
    fun update(rollerShutter: RollerShutter)


    @Delete
    fun delete(rollerShutter: RollerShutter)


    @Query("SELECT * FROM rollerShutter_table")
    fun getAlLRollerShutter(): LiveData<List<RollerShutter>>

}