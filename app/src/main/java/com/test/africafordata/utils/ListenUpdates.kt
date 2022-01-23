package com.test.africafordata.utils


interface ListenUpdates {

    fun heaterUpdated(id: Int, name: String, mode: String, temperature: Double)

    fun lightUpdated(id: Int, name: String, mode: String, intensity: Int)

    fun rollerShutterUpdated(id: Int, name: String, position: Int)
}