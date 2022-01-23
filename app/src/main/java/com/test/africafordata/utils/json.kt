package com.test.africafordata.utils

import android.app.Application
import com.test.africafordata.R
import com.test.africafordata.classes.User
import com.test.africafordata.classes.device.Devices
import com.test.africafordata.classes.device.Heater
import com.test.africafordata.classes.device.Light
import com.test.africafordata.classes.device.RollerShutter
import org.json.JSONObject
import java.nio.charset.Charset
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class json @Inject constructor(val application: Application) {

    private fun readFile(): String {
        val ins = application.resources.openRawResource(R.raw.jsondata)

        return ins.readBytes().toString(Charset.defaultCharset())
    }

    fun parseDevices(): ArrayList<Devices> {
        val deviceList = ArrayList<Devices>()
        val jsonFile = readFile()

        val mainJson = JSONObject(jsonFile)

        val devicesJsonArray = mainJson.getJSONArray("devices")
        var i = 0
        while (i < devicesJsonArray.length()) {
            val device = devicesJsonArray.getJSONObject(i)
            when (device.getString("productType")) {
                "Light" -> deviceList.add(
                    Light(
                        device.getInt("id"),
                        device.getString("deviceName"),
                        device.getString("mode"),
                        device.getInt("intensity")
                    )
                )

                "Heater" -> deviceList.add(
                    Heater(
                        device.getInt("id"),
                        device.getString("deviceName"),
                        device.getString("mode"),
                        device.getDouble("temperature")
                    )
                )

                "RollerShutter" -> deviceList.add(
                    RollerShutter(
                        device.getInt("id"),
                        device.getString("deviceName"),
                        device.getInt("position")
                    )
                )
            }
            i += 1
        }
        return deviceList

    }

    fun parseUser(): User {
        val jsonFile = readFile()
        val mainJson = JSONObject(jsonFile)
        val userJson = mainJson.getJSONObject("user")
        val address = userJson.getJSONObject("address")


        return User(
            userJson.getString("firstName"),
            userJson.getString("lastName"),
            address.getString("city"),
            address.getInt("postalCode"),
            address.getString("street"),
            address.getString("streetCode"),
            address.getString("country"),
            userJson.getLong("birthDate")
        )
    }

}
