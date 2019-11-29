package com.welcome.jetpack_learn.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.welcome.jetpack_learn.data.bean.Component
import com.welcome.jetpack_learn.data.db.HomeDB
import com.welcome.jetpack_learn.utils.Constants.COMPONENT_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(COMPONENT_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Component>>() {}.type
                    val plantList: List<Component> = Gson().fromJson(jsonReader, plantType)
                    val database = HomeDB.getInstance(applicationContext)
                    database.homeDao().insertAll(plantList)
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

}