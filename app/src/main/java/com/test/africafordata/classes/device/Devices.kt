package com.test.africafordata.classes.device

interface Devices {
    companion object {
        const val TYPE_Heater = 111
        const val TYPE_LIGHT = 112
        const val TYPE_ROLLER_SHUTTER = 113
    }

    fun getType(): Int

}