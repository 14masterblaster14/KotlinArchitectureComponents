package com.example.admin.myapplication

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {

            if (INSTANCE == null) {

                synchronized(this)
                {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app-databse")
                            // uncomment to allow queries on the main thread.
                            /*       .allowMainThreadQueries()*/
                            .build()
                }
            }

            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}