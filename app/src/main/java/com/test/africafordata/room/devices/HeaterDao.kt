package com.test.africafordata.room.devices

import androidx.lifecycle.LiveData
import androidx.room.*
import com.test.africafordata.model.device.Heater


@Dao
interface HeaterDao {


    @Insert
    fun insert(heater: Heater)


    @Update
    fun update(heater: Heater)


    @Delete
    fun delete(heater: Heater)


    @Query("SELECT * FROM heater_table")
    fun getAllHeaters(): LiveData<List<Heater>>

}