package com.test.africafordata.ui.fragments.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.test.africafordata.model.device.Devices
import com.test.africafordata.room.devices.DevicesRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(val devicesRepository: DevicesRepository) : ViewModel() {

    private val heaters = devicesRepository.getAllHeaters()
    private var lights = devicesRepository.getAllLights()
    private var rollerShutters = devicesRepository.getAllRollerShutter()


    private val allDevices: MediatorLiveData<List<Devices>> = MediatorLiveData()

    init {
        allDevices.addSource(heaters) {
            val list = ArrayList<Devices>()
            heaters.value?.let { list.addAll(it) }
            lights.value?.let { list.addAll(it) }
            rollerShutters.value?.let { list.addAll(it) }

            allDevices.value = list

        }
        allDevices.addSource(lights) {
            val list = ArrayList<Devices>()
            heaters.value?.let { list.addAll(it) }
            lights.value?.let { list.addAll(it) }
            rollerShutters.value?.let { list.addAll(it) }
            allDevices.value = list


        }
        allDevices.addSource(rollerShutters) {
            val list = ArrayList<Devices>()
            heaters.value?.let { list.addAll(it) }
            lights.value?.let { list.addAll(it) }
            rollerShutters.value?.let { list.addAll(it) }
            allDevices.value = list

        }
    }

    fun checkedRadioHeaters() {
        devicesRepository.checkedRadioHeaters()

    }

    fun uncheckedRadioHeaters() {
        devicesRepository.uncheckedRadioHeaters()
    }

    fun checkedRadioLights() {
        devicesRepository.checkedRadioLights()
    }

    fun uncheckedRadioLights() {
        devicesRepository.uncheckedRadioLights()
    }

    fun checkedRadioRollerShutter() {
        devicesRepository.checkedRadioRollerShutter()
    }

    fun uncheckedRadioRollerShutter() {
        devicesRepository.uncheckedRadioRollerShutter()
    }

    fun deleteDevice(devices: Devices) {
        devicesRepository.delete(devices)
    }

    fun updateDevice(devices: Devices) {
        devicesRepository.update(devices)
    }


    fun getAllDevices() = allDevices


}