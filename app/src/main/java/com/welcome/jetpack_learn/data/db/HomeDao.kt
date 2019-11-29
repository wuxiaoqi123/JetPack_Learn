package com.welcome.jetpack_learn.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.welcome.jetpack_learn.data.bean.Component

@Dao
interface HomeDao {
    @Query("SELECT * FROM component ORDER BY id")
    fun getComponents(): LiveData<List<Component>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Component>)
}