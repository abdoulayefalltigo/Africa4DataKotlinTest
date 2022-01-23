package com.test.africafordata.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.test.africafordata.App
import com.test.africafordata.dagger.DaggerAppComponent
import com.test.africafordata.classes.User
import com.test.africafordata.classes.device.Heater
import com.test.africafordata.classes.device.Light
import com.test.africafordata.classes.device.RollerShutter
import com.test.africafordata.room.devices.HeaterDao
import com.test.africafordata.room.devices.LightDao
import com.test.africafordata.room.devices.RollerShutterDao
import com.test.africafordata.room.user.UserDao
import javax.inject.Singleton

@Singleton
@Database(entities = [User::class, Heater::class, Light::class, RollerShutter::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    @Singleton
    class PopulateDbAsyncTask constructor(appDatabase: AppDatabase, app: App) :
        AsyncTask<Unit, Unit, Unit>() {
        private val jsonUtils =
            DaggerAppComponent.builder().application(app).build().getJsonUtils()
        private val userDao = appDatabase.userDao()
        private val lightDao = appDatabase.lightDao()
        private val heaterDao = appDatabase.heaterDao()
        private val rollerShutterDao = appDatabase.rollerShutterDao()
        override fun doInBackground(vararg params: Unit?) {

            val deviceList = jsonUtils.parseDevices()
            deviceList.forEach {
                when (it) {
                    is Light -> lightDao.insert(it)
                    is Heater -> heaterDao.insert(it)
                    is RollerShutter -> rollerShutterDao.insert(it)
                }
            }
            val user = jsonUtils.parseUser()
            userDao.insert(user)
        }


    }


    abstract fun userDao(): UserDao

    abstract fun heaterDao(): HeaterDao

    abstract fun lightDao(): LightDao

    abstract fun rollerShutterDao(): RollerShutterDao

    companion object {
        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.let { PopulateDbAsyncTask(it, application).execute() }
            }
        }

        @Volatile
        private var instance: AppDatabase? = null
        lateinit var application: App
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }.also {
                application = context as App
            }

        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "testapp_database.db"
        )
            .fallbackToDestructiveMigration()
            .addCallback(roomCallback)
            .build()
    }


}