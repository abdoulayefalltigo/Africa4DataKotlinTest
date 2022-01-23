package com.test.africafordata.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tbl_users")
data class User(
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "postalCode")
    val postalCode: Int,
    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "streetCode")
    val streetCode: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "birthDate")
    val birthDate: Long
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}