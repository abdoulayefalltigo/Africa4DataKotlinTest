package com.test.africafordata.room.devices


import android.app.Application
import androidx.lifecycle.MediatorLiveData
import com.test.africafordata.model.device.Devices
import com.test.africafordata.model.device.Heater
import com.test.africafordata.model.device.Light
import com.test.africafordata.model.device.RollerShutter
import com.test.africafordata.room.AppDatabase
import javax.inject.Inject

class DevicesRepository @Inject constructor(val application: Application) {

    private val heaterDao: HeaterDao

    private val lightDao: LightDao

    private val rollerShutterDao: RollerShutterDao

    private val allLights = MediatorLiveData<List<Light>>()


    private val allHeaters = MediatorLiveData<List<Heater>>()

    private val allRollerShutter = MediatorLiveData<List<RollerShutter>>()

    init {
        val devicesDatabase =
            AppDatabase(application)
        heaterDao = devicesDatabase.heaterDao()
        allHeaters.addSource(heaterDao.getAllHeaters()) {
            allHeaters.value = it
        }

        lightDao = devicesDatabase.lightDao()
        allLights.addSource(lightDao.getAllLights()) {
            allLights.value = it
        }

        rollerShutterDao = devicesDatabase.rollerShutterDao()
        allRollerShutter.addSource(rollerShutterDao.getAlLRollerShutter()) {
            allRollerShutter.value = it
        }
    }

    fun insert(device: Devices) {
        when (device) {
            is Light -> {
                lightDao.insert(device)
            }
            is Heater -> {
                heaterDao.insert(device)
            }
            is RollerShutter -> {
                rollerShutterDao.insert(device)
            }
        }
    }

    fun delete(device: Devices) {
        when (device) {
            is Light -> {
                lightDao.delete(device)
            }
            is Heater -> {
                heaterDao.delete(device)
            }
            is RollerShutter -> {
                rollerShutterDao.delete(device)
            }
        }
    }

    fun update(device: Devices) {
        when (device) {
            is Light -> {
                lightDao.update(device)
            }
            is Heater -> {
                heaterDao.update(device)
            }
            is RollerShutter -> {
                rollerShutterDao.update(device)
            }
        }
    }

    fun checkedRadioHeaters() {
        allHeaters.addSource(heaterDao.getAllHeaters()) {
            allHeaters.value = it
        }

    }

    fun uncheckedRadioHeaters() {
        allHeaters.removeSource(heaterDao.getAllHeaters())
        allHeaters.value = listOf()
    }

    fun checkedRadioLights() {
        allLights.addSource(lightDao.getAllLights()) {
            allLights.value = it
        }
    }

    fun uncheckedRadioLights() {
        allLights.removeSource(lightDao.getAllLights())
        allLights.value = listOf()
    }

    fun checkedRadioRollerShutter() {
        allRollerShutter.addSource(rollerShutterDao.getAlLRollerShutter()) {
            allRollerShutter.value = it
        }
    }

    fun uncheckedRadioRollerShutter() {
        allRollerShutter.removeSource(rollerShutterDao.getAlLRollerShutter())
        allRollerShutter.value = listOf()

    }

    fun getAllLights() = allLights

    fun getAllHeaters() = allHeaters

    fun getAllRollerShutter() = allRollerShutter
}