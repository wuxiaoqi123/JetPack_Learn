package com.welcome.jetpack_learn.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.welcome.jetpack_learn.data.Converters
import com.welcome.jetpack_learn.data.bean.Component
import com.welcome.jetpack_learn.utils.Constants.DATABASE_NAME
import com.welcome.jetpack_learn.workers.SeedDatabaseWorker

@Database(entities = [Component::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class HomeDB : RoomDatabase() {

    abstract fun homeDao(): HomeDao

    companion object {
        @Volatile
        private var instance: HomeDB? = null

        fun getInstance(context: Context): HomeDB {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): HomeDB {
            return Room.databaseBuilder(context, HomeDB::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                }).build()
        }
    }
}