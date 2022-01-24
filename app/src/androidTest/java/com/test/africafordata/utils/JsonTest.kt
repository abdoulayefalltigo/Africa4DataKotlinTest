package com.test.africafordata.utils

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.test.africafordata.R
import com.test.africafordata.classes.device.Heater
import com.test.africafordata.classes.device.Light
import com.test.africafordata.classes.device.RollerShutter
import com.test.africafordata.room.AppDatabase.Companion.application
import com.test.africafordata.screens.activities.MainActivity
import com.test.africafordata.screens.activities.MainActivityTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class JsonTest {

    @get:Rule
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    lateinit var jsonUtils: json

    @Before
    fun setUp() {
        jsonUtils = json(mActivityTestRule.activity.application)
    }

    @After
    fun tearDown() {
    }


    @Test
    fun parseDevices() {
        val devices = jsonUtils.parseDevices()
        assertNotNull(devices)
        assert(devices.isEmpty())
        assertEquals(devices.size, 12)
        assert(devices[0] is Light)
        assertEquals((devices[0] as Light).intensity, 50)
        assert(devices[1] is RollerShutter)
        assertEquals((devices[1] as RollerShutter).position, 70)
        assert(devices[2] is Heater)
        assertEquals((devices[2] as Heater).temperature.toInt(), 20)
    }

    @Test
    fun parseUser() {
        val user = jsonUtils.parseUser()
        assertEquals(user.country, "France")
        assertEquals(user.firstName, "John")
        assertEquals(user.lastName, "Doe")
        assertEquals(user.streetCode, "2B")
    }

    @Test
    fun getApplication() {
        assertNotNull(application)
    }

}